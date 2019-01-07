package volley.ejb.services;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import volley.Client.InterfaceCore.CoreMatchesInterface;
import volley.Client.Object.Object_Matches;
import volley.ejb.Utility.Utils;

/**
 * Session Bean implementation class Core
 */

@TransactionManagement(TransactionManagementType.BEAN)
@Stateless
@Remote(CoreMatchesInterface.class)
public class CoreMatches implements CoreMatchesInterface, Serializable{
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "VolleyDB")
	private EntityManager VolleyDB;

	private Utils utils;
	
	//Public function
	public List<Object_Matches> getAllMatches(HashMap<String, Object> params){
		TypedQuery<Object_Matches> q;
		
		String sql = null;
		{	
			String category = params.get("category").toString();
			String committee = params.get("committee").toString();
			char round = params.get("round").toString().charAt(0);
			char gender = params.get("gender").toString().charAt(0);
			
			int idLeague = utils.getIdLeague(category, committee, round, gender, VolleyDB);
			
			String selectQuery = "SELECT new volley.Client.Object.Object_Matches( m.ID_MATCH, m.MATCH_DATE, m.SITE, m.START_TIME, m.END_TIME, " + 
						"m.ID_ARBITER, m.HOME_TEAM, m.GUEST_TEAM, m.POINT_HOME, " + 
						"m.SET_HOME, m.POINT_GUEST,	m.SET_GUEST ) "; 
			String fromQuery = "from Match m join m.team_Home h join m.team_Guest g ";
			String whereQuery = "Where h.ID_LEAGUE = ?1 and g.ID_LEAGUE = ?1 ";
			String orderByQuery = "ORDER BY m.MATCH_DATE ";
		
			sql = selectQuery +
				fromQuery +
				whereQuery +
				orderByQuery;
		
		q = VolleyDB.createQuery(sql, Object_Matches.class);
		
		q.setParameter(1, idLeague);
		}
		
		return q.getResultList();
	}
	
	public List<Object_Matches> getWeekMatch(){
		TypedQuery<Object_Matches> q;
		
		String sql = null;
		{	
			
			String selectQuery = "SELECT new volley.Client.Object.Object_Matches( m.ID_MATCH, m.MATCH_DATE, m.SITE, m.START_TIME, m.END_TIME, " + 
						"m.ID_ARBITER, m.HOME_TEAM, m.GUEST_TEAM, m.POINT_HOME, " + 
						"m.SET_HOME, m.POINT_GUEST,	m.SET_GUEST, l.CATEGORY ) "; 
			String fromQuery = "from Match m join m.team_Home h join m.team_Guest g , League l ";
			String whereQuery = "Where h.ID_LEAGUE = l.ID_LEAGUE and g.ID_LEAGUE = l.ID_LEAGUE and (m.MATCH_DATE >= current_date() and m.MATCH_DATE <= date(?1))";
			String orderByQuery = "ORDER BY m.MATCH_DATE ";
		
			sql = selectQuery +
				fromQuery +
				whereQuery +
				orderByQuery;
		
		q = VolleyDB.createQuery(sql, Object_Matches.class);
		
		}
		
		Date date = new Date();
		
		LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		
		localDateTime = localDateTime.plusDays(7);


		q.setParameter(1,  localDateTime.toLocalDate().toString());
		
		return q.getResultList();
	}
		
}

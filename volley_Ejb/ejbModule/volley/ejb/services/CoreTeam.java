package volley.ejb.services;

import java.io.Serializable;
import java.util.HashMap;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import volley.Client.InterfaceCore.CoreTeamInterface;
import volley.Client.Object.Object_Society;
import volley.ejb.Utility.Utils;

@TransactionManagement(TransactionManagementType.BEAN)
@Stateless
@Remote(CoreTeamInterface.class)
public class CoreTeam implements CoreTeamInterface, Serializable{
	private static final long serialVersionUID = 1L;

	private Utils utils = new Utils();
	
	@PersistenceContext(unitName = "VolleyDB")
	private EntityManager VolleyDB;
	
	
	//Public function
	@Transactional
	public String insertNewTeam (HashMap<String, Object> params) {
		Query q;
		
		// Getting info DB
		String category = params.get("category").toString();
		String committee = params.get("committee").toString();
		char round = params.get("round").toString().charAt(0);
		String societyName = params.get("societyName").toString();
		char genderLeague = params.get("genderLeague").toString().charAt(0);
		int idLeague = utils.getIdLeague(category,committee,round, genderLeague, VolleyDB);
		int IdSociety = getIdSociety(societyName);
		
		//params needed for query
		String teamName = params.get("teamName").toString();
		
		// inserting Team
		String sql = "insert into sys.VOLLEY_TEAM(NAME,ID_SOCIETY,ID_LEAGUE,POSITION,GENDER_TEAM) " + 
				"values (?1, " + 
				"?2, " + 
				"?3, " +
				"0, " + 
				"?4);";
		q = VolleyDB.createNativeQuery(sql);
		
		q.setParameter(1, teamName);
		q.setParameter(2, IdSociety);
		q.setParameter(3, idLeague);
		q.setParameter(4, genderLeague);
		
		q.executeUpdate();
		return "Team Inserted correctly";
	}

	
	
	
	//Private Function
 	private int getIdSociety(String society){
		TypedQuery<Object_Society> q;
		
		String sql = null;
		{
			String selectQuery = "SELECT new volley.Client.Object.Object_Society( s.ID_SOCIETY ) "; 
			String fromQuery = "FROM Society as s ";
			String whereQuery = "WHERE s.NAME = ?1 ";
		
			sql = selectQuery +
				fromQuery +
				whereQuery;
		}
		
		
		q = VolleyDB.createQuery(sql, Object_Society.class);
		
		
		q.setParameter(1, society);
		return q.getResultList().get(0).getID_SOCIETY();
	}
	
 	
}

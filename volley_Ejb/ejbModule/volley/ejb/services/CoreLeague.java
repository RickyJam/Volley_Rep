package volley.ejb.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import volley.Client.InterfaceCore.CoreLeagueInterface;
import volley.Client.Object.Object_League;
import volley.Client.Object.Object_Ranking;


@TransactionManagement(TransactionManagementType.BEAN)
@Stateless
@Remote(CoreLeagueInterface.class)
public class CoreLeague  implements CoreLeagueInterface, Serializable{
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "VolleyDB")
	private EntityManager VolleyDB;
	
	//Public Function
	public List<String> getAllCommittee(){
		TypedQuery<Object_League> q;
		
		String sql = null;
		{
			String selectQuery = "SELECT distinct new volley.Client.Object.Object_League( l.COMMITTEE, 'COMMITTEE') "; 
			String fromQuery = "FROM League l ";
		
			sql = selectQuery +
				fromQuery;
		}
		
		q = VolleyDB.createQuery(sql, Object_League.class);
		
		return getAllCommittee(q.getResultList());
	}
	
	public List<String> getProvincialCommittee(){
		TypedQuery<Object_League> q;
		
		String sql = null;
		{
			String selectQuery = "SELECT distinct new volley.Client.Object.Object_League( l.COMMITTEE, 'COMMITTEE') "; 
			String fromQuery = "FROM League l ";
			String whereQuery = "WHERE l.CATEGORY not in ('A','B','C','D')";
		
			sql = selectQuery +
				fromQuery +
				whereQuery;
		}
		
		q = VolleyDB.createQuery(sql, Object_League.class);
		
		return getAllCommittee(q.getResultList());
	}
	
	public List<String> getDistinctCategory(){
		TypedQuery<Object_League> q;
		
		String sql = null;
		{
			String selectQuery = "SELECT distinct new volley.Client.Object.Object_League( l.CATEGORY ) "; 
			String fromQuery = "FROM League l ";
		
			sql = selectQuery +
				fromQuery;
		}
		
		q = VolleyDB.createQuery(sql, Object_League.class);
		
		List<String> res = getAllCategory(q.getResultList());
		return res;
	}
	
	public List<Object_League> getLeagueForThisCategory(HashMap<String, Object> params) {
		TypedQuery<Object_League> q;

		String category = params.get("category").toString();
		String committee = params.get("committee").toString();
		
		String sql = null;
		{			
			String selectQuery = "SELECT new volley.Client.Object.Object_League( l.ID_LEAGUE, l.ROUND, l.CATEGORY, l.COMMITTEE, l.GENDER_LEAGUE, l.years ) "; 
			String fromQuery = "FROM League l ";
			String whereQuery = ""; 
			if(category.toUpperCase().equals("ALL"))
				whereQuery = "WHERE l.COMMITTEE = ?2 ";
			else
				whereQuery = "WHERE l.CATEGORY = ?1 and l.COMMITTEE = ?2 ";
			String orderByQuery = "ORDER BY l.CATEGORY, l.GENDER_LEAGUE, l.ROUND asc";
		
			sql = selectQuery +
				fromQuery +
				whereQuery +
				orderByQuery;
		
		q = VolleyDB.createQuery(sql, Object_League.class);
		
		if(!category.toUpperCase().equals("ALL"))
			q.setParameter(1, category);
		
		q.setParameter(2, committee);
		}
		return q.getResultList();
		//return parseCompleteLeague(q.getResultList());
	}	
	
	public List<Object_Ranking> getRanking(HashMap<String, Object> params) {
		Query q;
		
		String sql = null;
		{	
			String category = params.get("category").toString();
			String committee = params.get("committee").toString();
			char round = params.get("round").toString().charAt(0);
			char gender = params.get("gender").toString().charAt(0);

			String selectQuery = "SELECT new volley.Client.Object.Object_Ranking( r.NAME, r.SET_WON, r.POINT_DONE, r.POSITION ) "; 
			String fromQuery = "FROM FullRank r ";
			String whereQuery = "WHERE r.CATEGORY = ?1 and r.COMMITTEE = ?2 and r.ROUND = ?3 and r.GENDER_LEAGUE = ?4";
			
			sql = selectQuery + fromQuery + whereQuery;
		
			q = VolleyDB.createQuery(sql, Object_Ranking.class);
			
			q.setParameter(1, category);
			q.setParameter(2, committee);
			q.setParameter(3, round);
			q.setParameter(4, gender);
		}
		
		return q.getResultList();
	}
	
	public List<String> getCategoryLeague(HashMap<String, Object> params){
		TypedQuery<Object_League> q;
		
		String sql = null;
		{
			String committee = params.get("committee").toString();
			
			String selectQuery = "SELECT distinct new volley.Client.Object.Object_League( l.CATEGORY ) "; 
			String fromQuery = "FROM League l ";
			String whereQuery = "WHERE l.COMMITTEE = ?1";
		
			sql = selectQuery +
				fromQuery+
				whereQuery;
		
		
			q = VolleyDB.createQuery(sql, Object_League.class);
			q.setParameter(1, committee);
		}
		
		List<String> res = getAllCategory(q.getResultList());
		return res;
	}
	
	public List<String> getRoundCategory(HashMap<String, Object> params){
		TypedQuery<Object_League> q;
		
		String sql = null;
		{
			String committee = params.get("committee").toString();
			String category = params.get("category").toString();
			char gender = params.get("gender").toString().charAt(0);
			
			
			String selectQuery = "SELECT distinct new volley.Client.Object.Object_League( l.ROUND ) "; 
			String fromQuery = "FROM League l ";
			String whereQuery = "WHERE l.COMMITTEE = ?1 and l.CATEGORY = ?2 and l.GENDER_LEAGUE = ?3";
		
			sql = selectQuery +
				fromQuery+
				whereQuery;
		
		
			q = VolleyDB.createQuery(sql, Object_League.class);
			q.setParameter(1, committee);
			q.setParameter(2, category);
			q.setParameter(3, gender);
		}
		
		List<String> res = getAllRound(q.getResultList());
		return res;
	}
	
	
	
	
	
	
	
	
	
	
	
	//Private Function
	private List<String> getAllCommittee(List<Object_League> resultList) {
		List<String> res = new ArrayList<String>();
		
		for(Object_League row: resultList){
			res.add(row.getCOMMITTEE());
		}
		
		return res;
	}
 
	private List<String> getAllCategory(List<Object_League> resultList) {
		List<String> res = new ArrayList<String>();
		
		for(Object_League row: resultList){
			res.add(row.getCATEGORY());
		}
		
		return res;
	}
	
	private List<String> getAllRound(List<Object_League> resultList) {
		List<String> res = new ArrayList<String>();
		
		for(Object_League row: resultList){
			res.add(Character.toString(row.getROUND()));
		}
		
		return res;
	}
 

}

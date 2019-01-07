package volley.ejb.Utility;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import volley.Client.Object.Object_League;
import volley.Client.Object.Object_Team;


@TransactionManagement(TransactionManagementType.BEAN)
@Transactional
public class Utils implements Serializable{
	private static final long serialVersionUID = 1L;

	public int getIdLeague(String category, String committee, char round, char gender, EntityManager VolleyDB) {
		TypedQuery<Object_League> q;
		
		String sql = null;
		{
			String selectQuery = "SELECT new volley.Client.Object.Object_League( l.ID_LEAGUE, l.GENDER_LEAGUE ) "; 
			String fromQuery = "FROM League l ";
			String whereQuery = "WHERE l.CATEGORY = ?1 and l.COMMITTEE = ?2 and l.ROUND = ?3 and l.GENDER_LEAGUE = ?4";
		
			sql = selectQuery +
				fromQuery +
				whereQuery;
		}
		
		
		q = VolleyDB.createQuery(sql, Object_League.class);
		
		q.setParameter(1, category);
		q.setParameter(2, committee);
		q.setParameter(3, round);
		q.setParameter(4, gender);
		

		return q.getResultList().get(0).getID_LEAGUE();
	}
	
	@Transactional
	public int insertNewUser(HashMap<String, Object> params, EntityManager VolleyDB) {
		Query q;
		
		String name = params.get("name").toString();
		String surname = params.get("surname").toString();
		String CF = params.get("CF").toString();
		String birthday = new SimpleDateFormat("yyyy-MM-dd").format((Date) params.get("birthday"));		
		char gender = params.get("gender").toString().charAt(0);
		String nationality =  params.get("nationality").toString();
		
		String sql = "insert into sys.VOLLEY_USER(CF,USER_NAME,USER_SURNAME,BIRTHDAY,GENDER,NATIONALITY) "
				+ "values (?1, ?2, ?3, ?4, ?5, ?6);";
		try {
			q = VolleyDB.createNativeQuery(sql);
		
			q.setParameter(1, CF);
			q.setParameter(2, name);
			q.setParameter(3, surname);
			q.setParameter(4, birthday);
			q.setParameter(5, gender);
			q.setParameter(6, nationality);
		
			q.executeUpdate();
			return 0;
		}
		catch (Exception e) {
			e.printStackTrace();
			return 1;
		}
		
	}

	public void createCalendar(HashMap<String, Object> params, EntityManager VolleyDB) throws ParseException{
		List<Object_Team> team = null;
		int idLeague;
		{
			Query q;
			
			String category = params.get("category").toString();
			String committee = params.get("committee").toString();
			char round = params.get("round").toString().charAt(0);
			String societyName = params.get("societyName").toString();
			char genderLeague = params.get("genderLeague").toString().charAt(0);
			idLeague = getIdLeague(category, committee, round, genderLeague, VolleyDB);
			
			
			String selectQuery = "SELECT new volley.Client.Object.Object_Team( t.NAME ) ";
			String fromQuery = "FROM Team t join League l ";
			String whereQuery = "WHERE l.idLeague = ?1";
			
			String sql = selectQuery + 
					fromQuery +
					whereQuery;
			try {
				q = VolleyDB.createQuery(sql);
			
				q.setParameter(1, idLeague);
				
			
				team = q.getResultList();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		String startDate = new SimpleDateFormat("yyyy-MM-dd").format( new Date());
		Query q;
		//doppio for per i gironi di andata
		for(int i = 0; i < team.size() - 1; i++)
		{
			String teamHome = team.get(i).getNAME();
			String site = "Via dei cavalli, cermenate";			
			
			for(int j = i + 1; j < team.size() - 1; j++)
			{
				String currentDay = startDate;
				String teamGuest = team.get(j).getNAME();
				
				
				//query creazione match
				String sql = "insert into sys.VOLLEY_MATCH (MATCH_DATE,SITE,START_TIME,END_TIME,ID_ARBITER,HOME_TEAM,GUEST_TEAM,POINT_HOME,SET_HOME,POINT_GUEST,SET_GUEST) "
						+ "value (?1, ?2, '21:00', null, 0, ?3, ?4, 0, 0, 0, 0);";
				q = VolleyDB.createNativeQuery(sql);
				
				q.setParameter(1, currentDay);
				q.setParameter(2, site);
				q.setParameter(3, teamHome);
				q.setParameter(4, teamGuest);
				
				q.executeUpdate();
				
				currentDay = sevenDayIncrease(currentDay);
				
			}
			
			startDate = sevenDayIncrease(startDate);
		}
		
		
		//doppio for per i gironi di ritorno
		for(int i = team.size(); i > 0; i--)
		{
			String teamHome = team.get(i).getNAME();
			String site = "Via dei cavalli, cermenate";		
			
			for(int j = i - 1; j > 0; j--)
			{
				String currentDay = startDate;
				String teamGuest = team.get(j).getNAME();
				
				//query creazione match
				String sql = "insert into sys.VOLLEY_MATCH (MATCH_DATE,SITE,START_TIME,END_TIME,ID_ARBITER,HOME_TEAM,GUEST_TEAM,POINT_HOME,SET_HOME,POINT_GUEST,SET_GUEST) "
						+ "value (?1, ?2, '21:00', null, 0, ?3, ?4, 0, 0, 0, 0);";
				q = VolleyDB.createNativeQuery(sql);
				
				q.setParameter(1, currentDay);
				q.setParameter(2, site);
				q.setParameter(3, teamHome);
				q.setParameter(4, teamGuest);
				
				q.executeUpdate();
				
				currentDay = sevenDayIncrease(currentDay);
			}
			
			startDate = sevenDayIncrease(startDate);
		}
		

	}
	
	public Object updateCalendar() {
		return 0;
	}
	private String sevenDayIncrease(String startDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(startDate));
		cal.add(Calendar.DATE, 7);  // number of days to add
		return sdf.format(cal.getTime());
	}
	
	public enum category{
		A1	("A1"),
		A2	("A2"),
		B	("B"),
		C	("C"),
		D	("D"),
		Prima_Divisione	("Prima Divisione"),
		Seconda_Divisione	("Seconda Divisione"),
		Terza_Divisione	("Terza Divisione");
		
		private final String cat;
		category(String cat) { this.cat = cat; }
	    public String getValue() { return cat; }
	    
	    public static boolean contains(String test) {

	        for (category c : category.values()) {
	            if (c.name().equals(test)) {
	                return true;
	            }
	        }

	        return false;
	    }
	};

}

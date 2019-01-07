package volley.ejb.services;

import java.io.Serializable;
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
import javax.transaction.Transactional;

import volley.Client.InterfaceCore.CoreArbiterInterface;
import volley.Client.Object.Object_Arbitri;
import volley.ejb.Utility.Utils;

@TransactionManagement(TransactionManagementType.BEAN)
@Stateless
@Remote(CoreArbiterInterface.class)
public class CoreArbiter implements CoreArbiterInterface, Serializable{
	private static final long serialVersionUID = 1L;

	private Utils utils = new Utils();
	
	@PersistenceContext(unitName = "VolleyDB")
	private EntityManager VolleyDB;
	
	public List<Object_Arbitri> ArbitersList (HashMap<String, Object> params) {
		/*DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, - (int) (params.get("daysBefore")));*/
		
		TypedQuery<Object_Arbitri> q;
		String sql = "";
		{
			String selectQuery = "SELECT new volley.Client.Object.Object_Arbitri( a.CF, a.CATEGORY, u.USER_NAME, u.USER_SURNAME, u.GENDER, u.NATIONALITY) "; 
			String fromQuery = "FROM Arbitri a join a.user u ";
			String whereQuery = "";
			String orderByQuery = "ORDER BY u.USER_NAME, u.USER_SURNAME ";
			
			
			if(params.get("categoria") != null && !params.get("category").equals(""))
			{
				whereQuery += "where a.CATEGORY = ?1 ";
			}
			
			sql = selectQuery +
					fromQuery +
					whereQuery +
					orderByQuery;
		}
		q = VolleyDB.createQuery(sql, Object_Arbitri.class);
		
		if(sql.contains("?1"))
			q.setParameter(1, params.get("categoria"));
		
		return q.getResultList();
	}
	
	@Transactional
	public String insertNewArbiter (HashMap<String, Object> params) {
		Query q;
		
		// Pushing user info
		if(utils.insertNewUser(params, VolleyDB) == 0) {
			
			//params needed for Arbiter
			char category = params.get("category").toString().charAt(0);
			String CF = params.get("CF").toString();
			
			try{
				// inserting Arbiter
				String sql = "insert into VOLLEY_ARBITER(CATEGORY, CF) " + 
						"value (?1, ?2);";
				
				q = VolleyDB.createNativeQuery(sql);
				
				q.setParameter(1, category);
				q.setParameter(2, CF);
				
				q.executeUpdate();
				return "Arbiter Inserted Correctly";
			} 
			catch (Exception e) {
				e.printStackTrace();
				return "Error While Inserting Player Info";
			}
		} else {
			return "Error While Inserting User Info";
		}
		
	}

}

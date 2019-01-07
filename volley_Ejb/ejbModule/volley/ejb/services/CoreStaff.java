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
import javax.transaction.Transactional;

import volley.Client.InterfaceCore.CoreStaffInterface;
import volley.ejb.Utility.Utils;

@TransactionManagement(TransactionManagementType.BEAN)
@Stateless
@Remote(CoreStaffInterface.class)
public class CoreStaff implements CoreStaffInterface, Serializable{
	private static final long serialVersionUID = 1L;

	private Utils utils = new Utils();
	
	@PersistenceContext(unitName = "VolleyDB")
	private EntityManager VolleyDB;
	
	@Transactional
	public String insertNewStaff (HashMap<String, Object> params) {
		Query q;
		
		// Pushing user info
		if(utils.insertNewUser(params, VolleyDB) == 0) {
			
			//params needed for Staff
			char role = params.get("role").toString().charAt(0);
			String CF = params.get("CF").toString();
			String teamName = params.get("teamName").toString();
			
			try{
				// inserting Staff
				String sql = "insert into VOLLEY_STAFF(NAME_TEAM, ROLE, CF) " + 
						"value (?1, ?2, ?3);";
				
				q = VolleyDB.createNativeQuery(sql);
				
				q.setParameter(1, teamName);
				q.setParameter(2, role);
				q.setParameter(3, CF);
				
				q.executeUpdate();
				return "Staff Inserted Correctly";
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

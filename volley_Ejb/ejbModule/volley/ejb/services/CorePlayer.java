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

import volley.Client.InterfaceCore.CorePlayerInterface;
import volley.ejb.Utility.Utils;

@TransactionManagement(TransactionManagementType.BEAN)
@Stateless
@Remote(CorePlayerInterface.class)
public class CorePlayer implements CorePlayerInterface, Serializable{
	private static final long serialVersionUID = 1L;

	private Utils utils = new Utils();
	
	@PersistenceContext(unitName = "VolleyDB")
	private EntityManager VolleyDB;
	
	@Transactional
	public String insertNewPlayer (HashMap<String, Object> params) {
		Query q;
		
		// Pushing user info
		if(utils.insertNewUser(params, VolleyDB) == 0) {
			
			//params needed for player
			String teamName = params.get("teamName").toString();
			int height = (params.get("height") == null ? 0 : (int)params.get("height"));
			int weight = (params.get("weight") == null ? 0 : (int)params.get("weight"));
			String CF = params.get("CF").toString();
			
			try{
				// inserting Player
				String sql = "insert into VOLLEY_PLAYER(TEAM_NAME,HEIGHT,WEIGHT,CF) " + 
						"value (?1, ?2, ?3, ?4);";
				
				q = VolleyDB.createNativeQuery(sql);
				
				q.setParameter(1, teamName);
				q.setParameter(2, height);
				q.setParameter(3, weight);
				q.setParameter(4, CF);
				
				q.executeUpdate();
				return "Player Inserted Correctly";
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

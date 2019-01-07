package volley.ejb.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import volley.Client.InterfaceCore.CoreSocietyInterface;
import volley.Client.Object.Object_Society;

@TransactionManagement(TransactionManagementType.BEAN)
@Stateless
@Remote(CoreSocietyInterface.class)
public class CoreSociety implements CoreSocietyInterface, Serializable{
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "VolleyDB")
	private EntityManager VolleyDB;
	
	
	public List<String> getAllSocietyName() {
		TypedQuery<Object_Society> q;
		
		String sql = null;
		{
			String selectQuery = "SELECT distinct new volley.Client.Object.Object_Society( s.ID_SOCIETY, s.NAME ) "; 
			String fromQuery = "FROM Society s ";
		
			sql = selectQuery +
				fromQuery;
		}
		
		q = VolleyDB.createQuery(sql, Object_Society.class);
		
		List<String> res = getAllSocietyName(q.getResultList());
		return res;
	}
	
	
	private List<String> getAllSocietyName(List<Object_Society> resultList) {
		List<String> res = new ArrayList<String>();
		
		for(Object_Society row: resultList){
			res.add(row.getNAME());
		}
		
		return res;
	}

}

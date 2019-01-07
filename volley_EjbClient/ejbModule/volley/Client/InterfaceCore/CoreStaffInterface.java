package volley.Client.InterfaceCore;

import java.io.Serializable;
import java.util.HashMap;
import javax.ejb.Remote;

@Remote
public interface CoreStaffInterface extends Serializable{
	
	public String insertNewStaff (HashMap<String, Object> params);
	
}

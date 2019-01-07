package volley.Client.InterfaceCore;

import java.io.Serializable;
import java.util.HashMap;
import javax.ejb.Remote;

@Remote
public interface CorePlayerInterface extends Serializable{
	
	public String insertNewPlayer (HashMap<String, Object> params);
	
}

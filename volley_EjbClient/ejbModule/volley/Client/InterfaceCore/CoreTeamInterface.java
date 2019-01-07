package volley.Client.InterfaceCore;

import java.io.Serializable;
import java.util.HashMap;

import javax.ejb.Remote;

@Remote
public interface CoreTeamInterface extends Serializable{

	public String insertNewTeam (HashMap<String, Object> params);
	
}

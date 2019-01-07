package volley.Client.InterfaceCore;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.ejb.Remote;

import volley.Client.Object.Object_Matches;

@Remote
public interface CoreMatchesInterface extends Serializable{
	
	public List<Object_Matches> getAllMatches(HashMap<String, Object> params);
	
	public List<Object_Matches> getWeekMatch();
	
}

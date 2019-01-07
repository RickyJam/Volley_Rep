package volley.Client.InterfaceCore;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.ejb.Remote;

import volley.Client.Object.Object_League;
import volley.Client.Object.Object_Ranking;

@Remote
public interface CoreLeagueInterface extends Serializable{

	public List<String> getAllCommittee();
	
	public List<String> getProvincialCommittee();
	
	public List<Object_League> getLeagueForThisCategory (HashMap<String, Object> params);
	
	public List<String> getDistinctCategory();
	
	public List<Object_Ranking> getRanking(HashMap<String, Object> params);
	
	public List<String> getCategoryLeague(HashMap<String, Object> params);
	
	public List<String> getRoundCategory(HashMap<String, Object> params);
}

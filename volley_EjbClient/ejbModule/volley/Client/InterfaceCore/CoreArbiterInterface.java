package volley.Client.InterfaceCore;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.ejb.Remote;

import volley.Client.Object.Object_Arbitri;

@Remote
public interface CoreArbiterInterface extends Serializable{
	
	public List<Object_Arbitri> ArbitersList (HashMap<String, Object> params);
	
	public String insertNewArbiter (HashMap<String, Object> params);
	
}

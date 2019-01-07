package volley.Client.InterfaceCore;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface CoreSocietyInterface extends Serializable{

	public List<String> getAllSocietyName();
	
}

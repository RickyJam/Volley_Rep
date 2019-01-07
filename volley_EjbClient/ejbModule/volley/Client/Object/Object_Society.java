package volley.Client.Object;

import java.io.Serializable;

public class Object_Society implements Serializable {
	private static final long serialVersionUID = 1L;

	private int ID_SOCIETY;
	private String NAME;
	
	public Object_Society() {
		// TODO Auto-generated constructor stub
	}
	
	//Full mapper
	public Object_Society(int ID_SOCIETY, String NAME) {
		this.setID_SOCIETY(ID_SOCIETY);
		this.setNAME(NAME);
	}
	
	public Object_Society(int ID_SOCIETY) {
		this.setID_SOCIETY(ID_SOCIETY);
	}
	
	
	//Getter And Setter//
	
	public int getID_SOCIETY() {
		return ID_SOCIETY;
	}

	public void setID_SOCIETY(int ID_SOCIETY) {
		this.ID_SOCIETY = ID_SOCIETY;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String NAME) {
		this.NAME = NAME;
	}

}

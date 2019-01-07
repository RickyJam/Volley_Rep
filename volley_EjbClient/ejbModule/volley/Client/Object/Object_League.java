package volley.Client.Object;

import java.io.Serializable;

public class Object_League  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int ID_LEAGUE;
	private char ROUND;
	private String CATEGORY;
	private String COMMITTEE;
	private char GENDER_LEAGUE;
	private String years;
	
	public Object_League ()
	{}
	
	// Full mapping query
	public Object_League (int ID_LEAGUE, char ROUND, String CATEGORY, String COMMITTEE, char GENDER_LEAGUE, String years){
		this.setCATEGORY(CATEGORY);
		this.setCOMMITTEE(COMMITTEE);
		this.setGENDER_LEAGUE(GENDER_LEAGUE);
		this.setID_LEAGUE(ID_LEAGUE);
		this.setROUND(ROUND);
		this.setYears(years);
	}	

	// mapping for Id and GENDER LEAGUE
	public Object_League (int ID_LEAGUE, char GENDER_LEAGUE){
		this.setID_LEAGUE(ID_LEAGUE);
		this.setGENDER_LEAGUE(GENDER_LEAGUE);
	}
	
	//Mapper for COMMITTEE
	public Object_League (String COMMITTEE, String Type){
		this.setCOMMITTEE(COMMITTEE);
	}
	
	public Object_League (char ROUND){
		this.setROUND(ROUND);
	}
	
	//mapper for Category
	public Object_League (String CATEGORY){
		this.setCATEGORY(CATEGORY);
	}
	
	public int getID_LEAGUE() {
		return ID_LEAGUE;
	}

	public void setID_LEAGUE(int ID_LEAGUE) {
		this.ID_LEAGUE = ID_LEAGUE;
	}

	public char getROUND() {
		return ROUND;
	}

	public void setROUND(char ROUND) {
		this.ROUND = ROUND;
	}

	public String getCATEGORY() {
		return CATEGORY;
	}

	public void setCATEGORY(String CATEGORY) {
		this.CATEGORY = CATEGORY;
	}

	public String getCOMMITTEE() {
		return COMMITTEE;
	}

	public void setCOMMITTEE(String COMMITTEE) {
		this.COMMITTEE = COMMITTEE;
	}

	public char getGENDER_LEAGUE() {
		return GENDER_LEAGUE;
	}

	public void setGENDER_LEAGUE(char GENDER_LEAGUE) {
		this.GENDER_LEAGUE = GENDER_LEAGUE;
	}

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}
	
	@Override
	public String toString() {
		String res = "";
		if(CATEGORY.toLowerCase().contains("div"))
			res = CATEGORY;
		else
			res = "Serie " + CATEGORY;
		
		if(GENDER_LEAGUE == 'M')
			res += " Maschile";
		else
			res += " Femminile";
		
		res += " Girone " + ROUND + " ("+ COMMITTEE +")";
		return res;
	}
	

}

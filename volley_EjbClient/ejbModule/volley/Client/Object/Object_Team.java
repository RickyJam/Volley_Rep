package volley.Client.Object;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

public class Object_Team implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	//Attributi
	private String NAME;
	private int ID_SOCIETY;
	private int ID_LEAGUE;
	private int POSITION;
	private char GENDER_TEAM;
	
	public Object_Team(String NAME, int ID_SOCIETY, int ID_LEAGUE, int POSITION, char GENDER_TEAM) {
		this.setGENDER_TEAM(GENDER_TEAM);
		this.setNAME(NAME);
		this.setID_LEAGUE(ID_LEAGUE);
		this.setID_SOCIETY(ID_SOCIETY);
		this.setPOSITION(POSITION);
	}
	
	public Object_Team(String NAME) {
		this.setNAME(NAME);
	}
	
	
	
	
	
	//Getter and Setter
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String NAME) {
		this.NAME = NAME;
	}
	public int getID_SOCIETY() {
		return ID_SOCIETY;
	}
	public void setID_SOCIETY(int ID_SOCIETY) {
		this.ID_SOCIETY = ID_SOCIETY;
	}
	public int getID_LEAGUE() {
		return ID_LEAGUE;
	}
	public void setID_LEAGUE(int ID_LEAGUE) {
		this.ID_LEAGUE = ID_LEAGUE;
	}
	public int getPOSITION() {
		return POSITION;
	}
	public void setPOSITION(int POSITION) {
		this.POSITION = POSITION;
	}
	public char getGENDER_TEAM() {
		return GENDER_TEAM;
	}
	public void setGENDER_TEAM(char GENDER_TEAM) {
		this.GENDER_TEAM = GENDER_TEAM;
	}
	
}

package volley.Client.Object;

import java.io.Serializable;
import java.util.Date;

public class Object_Arbitri implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	//Attributi
	private String CF;
	private String CATEGORY;
	private int ID_ARBITER;
	private String USER_NAME;
	private String USER_SURNAME;
	private Date BIRTHDAY;
	private char GENDER;
	private String NATIONALITY;
	
	//mapper only for Arbitri
	public Object_Arbitri(int ID_ARBITER, String CATEGORY,String CF)
	{
		this.setCF(CF);
		this.setCATEGORY(CATEGORY);
		this.setID_ARBITER(ID_ARBITER);
	}
	
	//mapper for Arbitri and User togheter
	public Object_Arbitri(String CF, String CATEGORY, String USER_NAME, String USER_SURNAME, char GENDER, String NATIONALITY)
	{
		this.setCF(CF);
		this.setCATEGORY(CATEGORY);
		this.setUSER_NAME(USER_NAME);
		this.setUSER_SURNAME(USER_SURNAME);
		this.setGENDER(GENDER);
		this.setNATIONALITY(NATIONALITY);
	}

	public Object_Arbitri(int ID_ARBITER, String CATEGORY)
	{
		this.setID_ARBITER(ID_ARBITER);
		this.setCATEGORY(CATEGORY);
	}
	
	public String getCF() {
		return CF;
	}

	public void setCF(String CF) {
		this.CF = CF;
	}

	public String getCATEGORY() {
		return CATEGORY;
	}

	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
	}

	public int getID_ARBITER() {
		return ID_ARBITER;
	}

	public void setID_ARBITER(int iD_ARBITER) {
		ID_ARBITER = iD_ARBITER;
	}

	public String getUSER_NAME() {
		return USER_NAME;
	}

	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}

	public String getUSER_SURNAME() {
		return USER_SURNAME;
	}

	public void setUSER_SURNAME(String uSER_SURNAME) {
		USER_SURNAME = uSER_SURNAME;
	}

	public Date getBIRTHDAY() {
		return BIRTHDAY;
	}

	public void setBIRTHDAY(Date bIRTHDAY) {
		BIRTHDAY = bIRTHDAY;
	}

	public char getGENDER() {
		return GENDER;
	}

	public void setGENDER(char gENDER) {
		GENDER = gENDER;
	}

	public String getNATIONALITY() {
		return NATIONALITY;
	}

	public void setNATIONALITY(String nATIONALITY) {
		NATIONALITY = nATIONALITY;
	}
	
}

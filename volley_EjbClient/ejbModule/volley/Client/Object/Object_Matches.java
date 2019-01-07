package volley.Client.Object;

import java.io.Serializable;
import java.util.Date;

public class Object_Matches implements Serializable{
	private static final long serialVersionUID = 1L;

	
	private int ID_MATCH;
	private Date MATCH_DATE;
	private String SITE;
	private String START_TIME;
	private String END_TIME;
	private int ID_ARBITER;
	private String HOME_TEAM;
	private String GUEST_TEAM;
	private int POINT_HOME;
	private int SET_HOME;
	private int POINT_GUEST;
	private int SET_GUEST;
	private String CATEGORY;
	
	public Object_Matches() {
	}

	public Object_Matches(int ID_MATCH, Date MATCH_DATE,String SITE, String START_TIME, String END_TIME, 
			int ID_ARBITER, String HOME_TEAM, String GUEST_TEAM, int POINT_HOME,
			int SET_HOME, int POINT_GUEST,	 int SET_GUEST, String CATEGORY)
	{
		this.setID_MATCH(ID_MATCH);
		this.setMATCH_DATE(MATCH_DATE);
		this.setSITE(SITE);
		this.setSTART_TIME(START_TIME);
		if(END_TIME == null)
			END_TIME = "00:00";
		this.setEND_TIME(END_TIME);
		
		this.setID_ARBITER(ID_ARBITER);
		this.setHOME_TEAM(HOME_TEAM);
		this.setGUEST_TEAM(GUEST_TEAM);
		this.setPOINT_GUEST(POINT_GUEST);
		this.setPOINT_HOME(POINT_HOME);
		this.setSET_HOME(SET_HOME);
		this.setSET_GUEST(SET_GUEST);
		this.setCATEGORY(CATEGORY);
	}

	
	
	
	
	
	
	
	public int getID_MATCH() {
		return ID_MATCH;
	}

	public void setID_MATCH(int ID_MATCH) {
		this.ID_MATCH = ID_MATCH;
	}

	public Date getMATCH_DATE() {
		return MATCH_DATE;
	}

	public void setMATCH_DATE(Date MATCH_DATE) {
		this.MATCH_DATE = MATCH_DATE;
	}

	public String getSITE() {
		return SITE;
	}

	public void setSITE(String SITE) {
		this.SITE = SITE;
	}

	public String getSTART_TIME() {
		return START_TIME;
	}

	public void setSTART_TIME(String START_TIME) {
		this.START_TIME = START_TIME;
	}

	public String getEND_TIME() {
		return END_TIME;
	}

	public void setEND_TIME(String END_TIME) {
		this.END_TIME = END_TIME;
	}

	public int getID_ARBITER() {
		return ID_ARBITER;
	}

	public void setID_ARBITER(int ID_ARBITER) {
		this.ID_ARBITER = ID_ARBITER;
	}

	public String getHOME_TEAM() {
		return HOME_TEAM;
	}

	public void setHOME_TEAM(String HOME_TEAM) {
		this.HOME_TEAM = HOME_TEAM;
	}

	public String getGUEST_TEAM() {
		return GUEST_TEAM;
	}

	public void setGUEST_TEAM(String GUEST_TEAM) {
		this.GUEST_TEAM = GUEST_TEAM;
	}

	public int getPOINT_HOME() {
		return POINT_HOME;
	}

	public void setPOINT_HOME(int POINT_HOME) {
		this.POINT_HOME = POINT_HOME;
	}

	public int getSET_HOME() {
		return SET_HOME;
	}

	public void setSET_HOME(int SET_HOME) {
		this.SET_HOME = SET_HOME;
	}
	
	public int getPOINT_GUEST() {
		return POINT_GUEST;
	}

	public void setPOINT_GUEST(int POINT_GUEST) {
		this.POINT_GUEST = POINT_GUEST;
	}

	public int getSET_GUEST() {
		return SET_GUEST;
	}

	public void setSET_GUEST(int SET_GUEST) {
		this.SET_GUEST = SET_GUEST;
	}

	public String getCategory() {
		return CATEGORY;
	}

	public void setCATEGORY(String CATEGORY) {
		this.CATEGORY = CATEGORY;
	}
}

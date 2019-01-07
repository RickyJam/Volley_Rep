package volley.Client.Object;

import java.io.Serializable;

public class Object_Ranking implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String NAME;
	private int ID_SOCIETY;
	private int ID_LEAGUE;
	private int POSITION;
	private int SET_WON;
	private int SET_LOST;
	private int POINT_DONE;
	private int POINT_SUFFERED;
	private int TOTAL_SET;
	private int TOTAL_POINT;
	
	
	public Object_Ranking() {
		super();
	}
	
	public Object_Ranking(String NAME, int ID_LEAGUE, int POSITION ) {
		this.setID_LEAGUE(ID_LEAGUE);
		this.setNAME(NAME);
		this.setPOSITION(POSITION);
	}
	
	//Mapper Just for position and Team Name
	public Object_Ranking(String NAME, int POSITION) {
		this.setID_LEAGUE(ID_LEAGUE);
		this.setID_SOCIETY(ID_SOCIETY);
		this.setNAME(NAME);
		this.setPOSITION(POSITION);
	}
	
	//Full Mapper
	public Object_Ranking(String NAME,int ID_SOCIETY,int ID_LEAGUE,int POSITION, int SET_WON, int SET_LOST, int POINT_DONE, int POINT_SUFFERED) {
		this.setID_LEAGUE(ID_LEAGUE);
		this.setID_SOCIETY(ID_SOCIETY);
		this.setNAME(NAME);
		this.setPOSITION(POSITION);
		this.setSET_WON(SET_WON);
		this.setSET_LOST(SET_LOST);
		this.setPOINT_DONE(POINT_DONE);
		this.setPOINT_SUFFERED(POINT_SUFFERED);
	}
	
	public Object_Ranking(String NAME, int TOTAL_SET, int TOTAL_POINT, int POSITION) {
		this.setNAME(NAME);
		this.setPOSITION(POSITION);
		this.setTOTAL_POINT(TOTAL_POINT);
		this.setTOTAL_SET(TOTAL_SET);
	}
	
	
	
	
	
	
	//Getter and Setter
	
	public int getSET_WON() {
		return SET_WON;
	}

	public void setSET_WON(int SET_WON) {
		this.SET_WON = SET_WON;
	}

	public int getSET_LOST() {
		return SET_LOST;
	}

	public void setSET_LOST(int SET_LOST) {
		this.SET_LOST = SET_LOST;
	}

	public int getPOINT_DONE() {
		return POINT_DONE;
	}

	public void setPOINT_DONE(int POINT_DONE) {
		this.POINT_DONE = POINT_DONE;
	}

	public int getPOINT_SUFFERED() {
		return POINT_SUFFERED;
	}

	public void setPOINT_SUFFERED(int POINT_SUFFERED) {
		this.POINT_SUFFERED = POINT_SUFFERED;
	}
	
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

	public int getTOTAL_SET() {
		return TOTAL_SET;
	}

	public void setTOTAL_SET(int TOTAL_SET) {
		this.TOTAL_SET = TOTAL_SET;
	}

	public int getTOTAL_POINT() {
		return TOTAL_POINT;
	}

	public void setTOTAL_POINT(int TOTAL_POINT) {
		this.TOTAL_POINT = TOTAL_POINT;
	}

}

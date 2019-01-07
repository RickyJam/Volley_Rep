package volley.ejb.viewMapper;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VIEW_FULL_RANKING", schema = "sys")
public class FullRank  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NAME")
	private String NAME;
	
	
	@Column(name = "POSITION")
	private int POSITION;
	
	
	@Column(name = "SET_WON")
	private int SET_WON;
	
	
	@Column(name = "POINT_DONE")
	private int POINT_DONE;
	
	
	@Column(name = "CATEGORY")
	private String CATEGORY;
	
	
	@Column(name = "COMMITTEE")
	private String COMMITTEE;
	
	
	@Column(name = "ROUND")
	private char ROUND;
	
	
	@Column(name = "GENDER_LEAGUE")
	private char GENDER_LEAGUE;
	
	
	

}

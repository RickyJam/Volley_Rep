package volley.ejb.tableMapper;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Table(name = "VOLLEY_MATCH", schema = "sys")
public class Match implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_MATCH")
	private int ID_MATCH;
	
	@Column(name = "MATCH_DATE")
	private Date MATCH_DATE;
	
	@Column(name = "SITE")
	private String SITE;
	
	@Column(name = "START_TIME")
	private String START_TIME;
	
	@Column(name = "END_TIME")
	private String END_TIME;
	
	@Column(name = "ID_ARBITER")
	private int ID_ARBITER;
	
	@Column(name = "HOME_TEAM")
	private String HOME_TEAM;
	
	@Column(name = "GUEST_TEAM")
	private String GUEST_TEAM;
	
	@Column(name = "POINT_HOME")
	private int POINT_HOME;
	
	@Column(name = "SET_HOME")
	private int SET_HOME;
	
	@Column(name = "POINT_GUEST")
	private int POINT_GUEST;
	
	@Column(name = "SET_GUEST")
	private int SET_GUEST;
	
	@ManyToOne
    @JoinColumn(name="HOME_TEAM", nullable=false, insertable=false, updatable=false)
	private Team team_Home;
	
	@ManyToOne
    @JoinColumn(name="GUEST_TEAM", nullable=false, insertable=false, updatable=false)
	private Team team_Guest;

}

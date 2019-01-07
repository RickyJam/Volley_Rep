package volley.ejb.tableMapper;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "VOLLEY_TEAM", schema = "sys")
public class Team implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NAME")
	private String NAME;
	
	@Column(name = "ID_SOCIETY")
	private int ID_SOCIETY;
	
	@Column(name = "ID_LEAGUE")
	private int ID_LEAGUE;
	
	@Column(name = "POSITION")
	private int POSITION;
	
	@Column(name = "GENDER_TEAM")
	private char GENDER_TEAM;
	
	@ManyToOne
    @JoinColumn(name="ID_LEAGUE", nullable=false, insertable=false, updatable=false)
    private League league;
	
	@OneToMany(mappedBy = "team_Home")
	private Set<Match> HOME_TEAM;
	
	@OneToMany(mappedBy = "team_Guest")
	private Set<Match> GUEST_TEAM;
	
}

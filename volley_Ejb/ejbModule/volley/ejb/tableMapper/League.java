package volley.ejb.tableMapper;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "VOLLEY_LEAGUE", schema = "sys")
public class League implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name ="ID_LEAGUE")
	private int ID_LEAGUE;
	
	@Column(name ="ROUND")
	private char ROUND;
	
	
	@Column(name ="CATEGORY")
	private String CATEGORY;
	
	
	@Column(name ="COMMITTEE")
	private String COMMITTEE;
	
	
	@Column(name ="GENDER_LEAGUE")
	private char GENDER_LEAGUE;
	
	
	@Column(name ="years")
	private String years;
	
	
    @OneToMany(mappedBy = "league")
	private Set<Team> team;
	
}

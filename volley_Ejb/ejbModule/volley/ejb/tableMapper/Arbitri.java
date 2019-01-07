package volley.ejb.tableMapper;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import volley.ejb.tableMapper.User;

@Entity
@Table(name = "VOLLEY_ARBITER", schema = "sys")
public class Arbitri implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_ARBITER")
	private int ID_ARBITER;
	
	
	@Column(name = "CATEGORY")
	private String CATEGORY;
	
	
	@Column(name = "CF")
	private String CF;
	
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CF", insertable=false, updatable=false)
	private User user;
	
}

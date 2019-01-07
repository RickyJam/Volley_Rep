package volley.ejb.tableMapper;

import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
@Table(name = "VOLLEY_SOCIETY", schema = "sys")
public class Society implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_SOCIETY")
	private int ID_SOCIETY;
	
	@Column(name = "NAME")
	private String NAME;

}

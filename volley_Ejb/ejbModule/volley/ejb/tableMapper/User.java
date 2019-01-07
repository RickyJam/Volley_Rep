package volley.ejb.tableMapper;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VOLLEY_USER", schema = "sys")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CF")
	private String CF;
	
	@Column(name = "USER_NAME")
	private String USER_NAME;
	
	@Column(name = "USER_SURNAME")
	private String USER_SURNAME;
	
	@Column(name = "BIRTHDAY")
	private Date BIRTHDAY;
	
	@Column(name = "GENDER")
	private char GENDER;
	
	@Column(name = "NATIONALITY")
	private String NATIONALITY;
	
}

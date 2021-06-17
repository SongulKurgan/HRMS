package kodlamaio.hrms.core.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name="users")


public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="email")
	@NotNull
	private String email;
	
	@Column(name="password")
	@NotNull
	private String password;
	
	public User() {}
	
	public User(int id, String email, String password) {
		this.id = id;
		this.email = email;
		this.password = password;
	}

}

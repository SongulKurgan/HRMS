package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import kodlamaio.hrms.core.concretes.User;
import lombok.Data;

@Data
@Entity
@Table(name="employers")
public class Employer extends User{
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_address")
	private String webAddress;
	
	
	public Employer() {}

	public Employer(int id, String companyName, String webAddress) {
		this.id = id;
		this.companyName = companyName;
		this.webAddress = webAddress;
	}

}

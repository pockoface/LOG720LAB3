package ca.etsmtl.log720.lab3.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table( name = "users",
uniqueConstraints = {
		@UniqueConstraint(columnNames = "user_name")
		}
)
public class Type implements Serializable{
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	private String user_name;
	private String password;
	private List<Role> roles;
	
	public User(){
		
	}
	
	public User(String user_name, String password) {
		this.user_name = user_name;
		this.password = password;
		this.roles = new ArrayList<Role>();
	}
	
	@Id
	@Column(name = "user_name", unique = true, nullable = false)
	public String getUser_name() {
		return user_name;
	}

	@Column(name = "password", unique = false, nullable = false)
	public String getPassword() {
		return password;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public List<Role> getRoles() {
		return roles;
	}
}

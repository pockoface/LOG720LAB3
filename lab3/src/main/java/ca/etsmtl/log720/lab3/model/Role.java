package ca.etsmtl.log720.lab3.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table( name = "roles",
uniqueConstraints = {
		@UniqueConstraint(columnNames = "role_name")
		}
)
public class Role {

	public void setRole(String role) {
		this.role = role;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	private String role;
	private List<User> users;
	
	public Role () {
		
	}
	
	public Role(String role){
		this.role = role;
		this.users = new ArrayList<User>();
	}
	
	@Id
	@Column(name = "role_name", unique = true, nullable = false)
	public String getRole() {
		return role;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "usersroles", joinColumns = {
			@JoinColumn(name = "role_name", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "user_name",
					nullable = false, updatable = false) })
	public List<User> getUsers() {
		return users;
	}
}

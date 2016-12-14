package ca.etsmtl.log720.lab3.dao.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.etsmtl.log720.lab3.dao.helper.UserDAO;
import ca.etsmtl.log720.lab3.model.Role;

public class UserServiceImpl implements UserDetailsService{
	
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Transactional
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		System.out.println("FUCK MKYOUNG -  loadUserByUsername");
		ca.etsmtl.log720.lab3.model.User user = this.userDAO.findUserByUsername(username);
		List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());
		return buildUserForAuthentication(user, authorities);
	}
	
	private User buildUserForAuthentication(ca.etsmtl.log720.lab3.model.User user,
			List<GrantedAuthority> authorities) {
			/*return new User(user.getUser_name(), user.getPassword(),
				true, true, true, true, authorities);*/
		return null;
	}

	private List<GrantedAuthority> buildUserAuthority(List<Role> roles) {
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		for (Role role : roles) {
			//setAuths.add(new SimpleGrantedAuthority(role.getRole()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
		return null;
	}

}

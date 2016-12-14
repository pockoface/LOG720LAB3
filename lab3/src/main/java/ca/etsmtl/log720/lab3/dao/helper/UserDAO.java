package ca.etsmtl.log720.lab3.dao.helper;

import ca.etsmtl.log720.lab3.model.User;

public interface UserDAO {
	public User findUserByUsername(String username);
}

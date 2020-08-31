package wb.service;

import wb.model.User;

public interface UserDAO {

	void insertNewUser(User user);

	User getNameOfUser(String login, String password);

}

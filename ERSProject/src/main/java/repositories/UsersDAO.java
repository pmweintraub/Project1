package repositories;

import models.Users;

public interface UsersDAO {
    Users getUserGivenUsername(String username);
    void createUser(Users users);
}

package services;

import models.Users;
import repositories.UsersDAO;
import repositories.UsersDAOImpl;

public class UsersService {

    private UsersDAO usersDAO;

    public UsersService(UsersDAO usersDAO){
        this.usersDAO = usersDAO;
    }

    public UsersService(){
        this.usersDAO = new UsersDAOImpl();
    }

    public Users validateCredentials(String username, String password){
        Users user = this.usersDAO.getUserGivenUsername(username);

        if(user == null)
            return null;

        if(!password.equals(user.getPassword()))
            return null;

        return user;

    }

    public void createUser(Users user){
        this.usersDAO.createUser(user);
    }
}
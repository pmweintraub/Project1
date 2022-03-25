package services;

import models.Users;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import repositories.UsersDAO;

import static org.junit.jupiter.api.Assertions.*;

public class UsersServiceTest {
    private UsersService usersService;

    private UsersDAO usersDao = Mockito.mock(UsersDAO.class);

    public UsersServiceTest(){
        this.usersService = new UsersService(usersDao);
    }

    @Test
    void validateCredentialsInvalidUsername() {
        String expectedUsername = "incorrectusername";
        String expectedPassword = "pass123";
        Users expectedOutput = null;
        Mockito.when(usersDao.getUserGivenUsername(expectedUsername)).thenReturn(expectedOutput);

        Users actualOutput = usersService.validateCredentials(expectedUsername,expectedPassword);

        Assertions.assertEquals(expectedOutput,actualOutput);

    }

    @Test
    void validateCredentialsInvalidPassword() {
        String expectedUsername = "correctusername";
        String expectedPassword = "pass123";
        Users expectedOutput = null;
        Users userFromDb = new Users("correctusername", "pass1234", "firstname", "lastname", "email", 1);
        Mockito.when(usersDao.getUserGivenUsername(expectedUsername)).thenReturn(userFromDb);

        Users actualOutput = usersService.validateCredentials(expectedUsername,expectedPassword);

        Assertions.assertEquals(expectedOutput,actualOutput);
    }

    @Test
    void validateCredentialsValidCredentials() {
        String expectedUsername = "correctusername";
        String expectedPassword = "correctpassword";
        Users expectedOutput = new Users(expectedUsername, expectedPassword, "user", "one", "email", 1);
        Mockito.when(usersDao.getUserGivenUsername(expectedUsername)).thenReturn(expectedOutput);

        Users actualOutput = usersService.validateCredentials(expectedUsername, expectedPassword);

        assertEquals(expectedOutput, actualOutput);

    }

    @Test
    void createUser(){
        Users userToPass = new Users("username", "password", "user", "one", "email", 1);

        usersService.createUser(userToPass);

        Mockito.verify(usersDao, Mockito.times(1)).createUser(userToPass);
    }
}

package controllers;

import io.javalin.http.Context;
import models.JsonResponse;
import models.Users;
import services.UsersService;

public class UsersController {
    private UsersService usersService;

    public UsersController(){
        this.usersService = new UsersService();
    }

    public UsersController(UsersService usersService){
        this.usersService = usersService;
    }

    public void login(Context context){
        JsonResponse jsonResponse;

        Users credentials = context.bodyAsClass(Users.class);

        Users userFromDb = usersService.validateCredentials(credentials.getUsername(), credentials.getPassword());

        if(userFromDb == null){
            jsonResponse = new JsonResponse(false, "invalid username or password", null);
        }else{
            context.sessionAttribute("user", userFromDb);
            if(userFromDb.getUserRole().equals(2)){
                jsonResponse = new JsonResponse(true, "manager login successful", userFromDb);
            }else{
                jsonResponse = new JsonResponse(true, "employee login successful", userFromDb);
            }
        }

        context.json(jsonResponse);

    }

    public void checkSession(Context context){
        Users users = context.sessionAttribute("user");

        if(users == null){
            context.json(new JsonResponse(false, "you are not logged in...redirecting", null));
        }else{
            context.json(new JsonResponse(true, "user is logged in", users));
        }
    }

    public void logout(Context context){
        context.sessionAttribute("user", null);

        context.json(new JsonResponse(true, "session has been invalidated", null));
    }

    /*public void createUser(Context context){
        Users users = context.bodyAsClass(Users.class);
        usersService.createUser(users);

        JsonResponse jsonResponse = new JsonResponse(true, "user has been created", null);
        context.json(jsonResponse);
    }*/
}

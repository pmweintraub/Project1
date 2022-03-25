import controllers.ReimbursementController;
import controllers.UsersController;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import models.JsonResponse;
import models.Users;
import repositories.ReimbursementDAO;
import repositories.ReimbursementDAOImpl;
import repositories.UsersDAO;
import repositories.UsersDAOImpl;
import services.UsersService;

public class MainDriver {
    public static void main(String[] args) {
        UsersDAO usersDAO = new UsersDAOImpl();
        ReimbursementDAO reimbursementDAO = new ReimbursementDAOImpl();

        System.out.println(usersDAO.getUserGivenUsername("user2"));

        System.out.println(reimbursementDAO.getAllReimbursementGivenUser(2));

        System.out.println(reimbursementDAO.showAllReimbursement());



        Javalin app = Javalin.create(config -> {
            config.addStaticFiles("/", Location.CLASSPATH);
        }).start(9000);

        UsersController usersController = new UsersController();
        ReimbursementController reimbursementController = new ReimbursementController();

        //app.post("/users", usersController::createUser);
        app.post("/login", usersController::login);
        app.delete("/logout", usersController::logout);
        app.get("/check", usersController::checkSession);
        app.get("/reimbs/all/{userId}", reimbursementController::getAllReimbursementGivenUser);
        app.get("/approve/{id}", reimbursementController::showAllReimbursement);
        app.patch("/approve/{id}", reimbursementController::approveReimbursement);
        app.patch("/deny/{id}", reimbursementController::denyReimbursement);
        app.post("/reimbs/create", reimbursementController::createReimbursement);


       /* app.post("/login", ctx -> {
            Users credentials = ctx.bodyAsClass(Users.class);

            Users userFromDb = new Users(1, credentials.getUsername(), credentials.getPassword(), "John", "Doe");

            ctx.sessionAttribute("user", userFromDb);

            ctx.json(new JsonResponse(true, "credentials valid and session attribute user created", userFromDb));
        });

        app.get("/check-session", ctx -> {
            Users user = ctx.sessionAttribute("user");

            if(user == null){
                ctx.json(new JsonResponse(false, "you are not logged in...redirecting", null));
            }else{
                ctx.json(new JsonResponse(true, "user is logged in", user));
            }

        });

        app.delete("/logout", ctx -> {
            ctx.sessionAttribute("user", null);

            ctx.json(new JsonResponse(true, "session has been invalidated", null));

        });*/

        //ReimbursementDAO reimbursementDAO = new ReimbursementDAOImpl();

        //System.out.println(reimbursementDAO.showAllReimbursement());

        //UsersService userService = new UsersService();

        //System.out.println(userService.validateCredentials("user1", "pass123"));

    }
}

package peaksoft;
import peaksoft.model.User;
import peaksoft.service.impl.UserServiceImpl;

/**
 * Hello world!
 **/
public class App {
    public static void main( String[] args ) {
        // Config.getConnection();
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUserTable();
        userService.saveUser(new User("Ernazar","Tilek uulu",18));
        System.out.println(userService.getAllUsers());

    }
}

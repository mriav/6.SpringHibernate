package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru").setCar(new Car("Car1", 11111)));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru").setCar(new Car("Car2", 22222)));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru").setCar(new Car("Car3", 33333)));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru").setCar(new Car("Car4", 44444)));
//      userService.add(new User("U22", "L23", "us2e2r@mail.ru").setCar(new Car("C222", 122)));
//
//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = " + user.getFirstName());
//         System.out.println("Last Name = " + user.getLastName());
//         System.out.println("Email = " + user.getEmail());
//      }

      User userCar = userService.fildCatByUser("C222", 122);

      System.out.println(userCar);


      context.close();
   }
}

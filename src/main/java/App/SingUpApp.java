package App;

import Entity.Cinema;
import Entity.User;

import Service.CinemaService;
import Service.UserService;

import java.util.Scanner;

public class SingUpApp {
    Scanner scanner = new Scanner(System.in);
    CinemaService cinemaService = new CinemaService();
    UserService userService = new UserService();
    UserApp userApp = new UserApp();
    public void menuForSingUp(){
        System.out.println("\t\tStart\n" +
                "\tif you cinema insert 1\n" +
                "\tif user insert 2" +
                "\t exit 3");
        int sec=scanner.nextInt();
        switch (sec){
            case 1:
                singUpCinema();
                break;
            case 2:
                singUpUser();
                break;
        }

    }
    public void singUpCinema(){
        System.out.println("\t\tWelcome\n" +
                "please insert your name");
        String name = scanner.next().trim();
        System.out.println("please insert passcode");
        int passcode = scanner.nextInt();
        System.out.println("please insert addres");
        String address= scanner.next().trim();
        Cinema cinema = new Cinema(name,address,passcode);
        cinemaService.singup(cinema);
    }
    public void singUpUser(){
        System.out.println("\tplease insert name");
        String name = scanner.next();
        System.out.println("\tplease insert passcode");
        int pass =scanner.nextInt();
        User user = new User(name,pass,0);
        userService.singUp(user);

    }
}

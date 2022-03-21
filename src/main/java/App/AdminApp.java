package App;

import Entity.Cinema;
import Entity.Ticket;
import Entity.User;
import Service.AdminService;

import java.util.List;
import java.util.Scanner;

public class AdminApp {
    AdminService adminService = new AdminService();
    Scanner scanner = new Scanner(System.in);
    public void activeing(){
        showAllCinema();
        System.out.println("\tplease insert name");
        String name =scanner.next().trim();
        adminService.adctive(name);
    }
    public void detiveing(){
        showAllCinema();
        System.out.println("\tplease insert name");
        String name =scanner.next().trim();
        adminService.adctive(name);
    }
    public void show(){
        System.out.println("for see all user insert 'user'\n" +
                "\tfor see all cinema insert 'cinema'\n" +
                "\tfor see all ticket insert ticket\n");
        String sectiom=scanner.next().trim();
        switch (sectiom){
            case "cinema":
              showAllCinema();
                break;
            case "user":
                List<User> users=adminService.allUser();
                users.forEach(System.out::println);
                break;
            case "ticket":
                List<Ticket> tickets = adminService.allTicket();
                tickets.forEach(System.out::println);
                break;
            default:

        }
    }
    private void showAllCinema(){
        List<Cinema> cinemaList = adminService.allCinme();
        cinemaList.forEach(System.out::println);
    }
}

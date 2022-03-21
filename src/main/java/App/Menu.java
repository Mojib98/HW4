package App;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    CinemaApp cinemaApp = new CinemaApp();
    AdminApp adminApp = new AdminApp();
    LogingApp logingApp = new LogingApp();
    sellingSystem sellingSystem = new sellingSystem();
    String name;
    int id;
    public void menu(){
        while (true){
        System.out.println("\t\tWelcome\n" +
                "\tif yor admin insert 'admin'\n" +
                "\tif you user insert 'user'\n" +
                "if you cinema insert 'cinema'");
        String swi=scanner.next();
        System.out.println("please insert id");
         id = scanner.nextInt();
        System.out.println("insert passcode");
        int pass= scanner.nextInt();
        switch (swi){
            case "admin":
                if (logingApp.admin(id,pass)){
                    admin();
                }
                break;
            case "user":
                if (logingApp.user(id,pass)){

                }
            case "cinema":
                if (logingApp.cinema(id,pass)){
                    cinemaApp.findName(id);
                    cinema();
                }
            default:
                continue;
        }
    }}
    public void admin(){
        boolean isRun =true;
        while (isRun){
            System.out.println("\t\tWelcome\n" +
                    "\tfor active menu insert 1\n" +
                    "\tfor deactive insert 2\n" +
                    "for show modle insert 3");
            int section = scanner.nextInt();
            switch (section){
                case 1:
                    adminApp.activeing();
                    break;
                case 2:
                    adminApp.detiveing();
                    break;
                case 3:
                    adminApp.show();
                    break;
                case 4:
                    isRun =false;
                    break;
            }
        }
    }
    public void cinema(){
        boolean isRun = true;
        cinemaApp.setId(id);
        while (isRun){
        System.out.println("\t\tWELCOME" +
                "\tfor insert ticket insert 1\n" +
                "\tfor cancel ticket insert \n "+
                "\tfor see All your ticket insert 3");
        int section = scanner.nextInt();
        switch (section){
            case 1:
                cinemaApp.insertTicket();
                break;
            case 2:
                break;
            case 3:
                cinemaApp.allMyTicket();
                break;
            case 4:
        }
    }}
    public void user(){
        boolean isRun=true;
        while (isRun){
            System.out.println("\t\tWELCOME\n" +
                    "\tfor buying insert 1\n" +
                    "\tfor find by name insert 2\n" +
                    "\tfor find by date insert 3\n" +
                    "for canceling insert 4\n" +
                    "for exit insert 5\n");
            int section=scanner.nextInt();
            switch (section){
                case 1:
                    sellingSystem.selling();
                    break;
                case 2:
                    sellingSystem.findByName();
                    break;
                case 3:
                    sellingSystem.findByDate();
                    break;
                case 4:
                case 5:
                case 6:

            }
        }
    }


}

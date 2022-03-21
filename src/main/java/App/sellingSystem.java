package App;

import Entity.Ticket;
import Service.AdminService;
import Service.UserService;

import java.util.List;
import java.util.Scanner;

public class sellingSystem {
    Scanner scanner = new Scanner(System.in);
    AdminService adminService = new AdminService();
    UserService userService = new UserService();
    Ticket ticket = null;
    int id;
    public void  selling(){
        List<Ticket> list = adminService.allTicket();
        var a= list.iterator();
        System.out.println("whats you movie named");
        String name = scanner.next();
        System.out.println("how much need");
        int number = scanner.nextInt();
        if (check(name,number,list)){
            userService.buying(this.id,ticket.getId(),number);
        }else System.out.println("can not buying try again");

    }
    private boolean check(String name,int number,List<Ticket> list){
        var iter = list.iterator();
        for(Ticket t:list){
            if (t.getMovieName().equals(name)){
                if (t.getNumber()>=number) {
                    ticket=t;
                    return true;
                }
            }
        }
        return false;
    }
    //change after
    public void findByName(){
        System.out.println("insert your movie name");
        String name = scanner.next().trim();
        List<Ticket> list=adminService.allTicket();
        for(Ticket t:list){
            if (t.getMovieName().equals(name)){
                System.out.println(t);
                }
            }

        }
    public void findByDate(){}


    }


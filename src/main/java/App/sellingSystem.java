package App;

import Entity.Ticket;
import Service.AdminService;

import java.util.List;
import java.util.Scanner;

public class sellingSystem {
    Scanner scanner = new Scanner(System.in);
    AdminService adminService = new AdminService();
    public void  selling(){
        List<Ticket> list = adminService.allTicket();
        var a= list.iterator();
        System.out.println("whats you movie named");
        String name = scanner.next();
        System.out.println("how much need");
        int number = scanner.nextInt();
        if (check(name,number,list)){

        }else System.out.println("can not buying try again");

    }
    private boolean check(String name,int number,List<Ticket> list){
        for(Ticket t:list){
            if (t.getMovieName().equals(name)){
                if (t.getNumber()>=number)
                    return true;
            }
        }
        return false;
    }
}

package App;

import Entity.Cinema;
import Entity.Ticket;
import Service.CinemaService;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

public class CinemaApp {
    CinemaService cinemaService = new CinemaService();
    Scanner scanner = new Scanner(System.in);
    private  String name;

    public void insertTicket(){
        System.out.print("\tplease insert movieName: ");
        String mName = scanner.next().trim();
        System.out.println();
        System.out.print("\tinsert price");
        int price = scanner.nextInt();
        System.out.println("please isnert number of ticket");
        int number = scanner.nextInt();
        System.out.print("Enter date(yyyy-dd-mm):");
       String timeDate = scanner.nextLine();
        Date timeD;
        try {
            timeD = Date.valueOf(timeDate);
        }catch (Exception exception){
            System.out.println("open your eyes and see the format!");
            return;
        }
        System.out.print("Enter time(HH:MM:SS):");
        String clock = scanner.nextLine();
        Time timeC;
        try {
            timeC = Time.valueOf(clock);
        }catch (Exception exception){
            System.out.println("open your eyes and see the format!");
            return;
        }
        Ticket ticket = new Ticket(this.name,price,number);
        ticket.setMovieName(mName);
        ticket.setTime(timeC);
        cinemaService.insertTicket(ticket);
    }
    public void allMyTicket(){
        cinemaService.setName(this.name);
        List<Ticket> list=cinemaService.myTicket();
        list.forEach(System.out::println);
    }
    public void findName(int id){
        this.name=cinemaService.myName(id);
    }


}

package Service;

import Entity.Cinema;
import Entity.Ticket;
import repository.CinemaRepository;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CinemaService {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    CinemaRepository cinemaRepository = new CinemaRepository();
    public void singup(Cinema cinema){
        try {
            cinemaRepository.singUp(cinema);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void insertTicket(Ticket ticket){
       // Date date = new Date();
   //     String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
     //   Timestamp timestamp2 = Timestamp.valueOf(timeStamp);
        if (true){
            try {
                cinemaRepository.insertTicket(ticket);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public void removeTicket(Ticket ticket){

    }
    public List<Ticket> myTicket(){
        List<Ticket> list = null;
        try {
            list=cinemaRepository.myTicket(this.name);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public String myName(int id){
        try {
            return cinemaRepository.findName(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

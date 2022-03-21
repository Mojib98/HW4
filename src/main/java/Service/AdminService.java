package Service;

import Entity.Cinema;
import Entity.Ticket;
import Entity.User;
import repository.AdminRepository;

import java.util.List;

public class AdminService {
    AdminRepository adminRepository = new AdminRepository();
    public void adctive(String name){
        try {
            adminRepository.activatingCinema(name);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deadctive(String name){
        try {
            adminRepository.deactivatingCinema(name);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public List<Cinema> allCinme(){
        List<Cinema> list = null;
        try {
            list=adminRepository.allCinemr();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public List<Ticket> allTicket(){
        List<Ticket> list = null;
        try {
            list=adminRepository.allTicket();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public List<User> allUser(){
        List<User> list = null;
        try {
            list=adminRepository.allUser();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

}

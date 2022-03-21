package Service;

import repository.AdminRepository;

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
    public void

}

package Service;

import repository.LoginRepository;

public class LoginService {
    LoginRepository loginRepository = new LoginRepository();
    public boolean cinema(int id , int passcode){
        try {
            return loginRepository.cinema(id,passcode);
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean user(int id , int passcode){
        try {
            return loginRepository.user(id,passcode);
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}

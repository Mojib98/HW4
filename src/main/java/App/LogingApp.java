package App;

import Service.LoginService;

public class LogingApp {
    LoginService loginService = new LoginService();
    public boolean user(int id,int passcode){
        return loginService.user(id,passcode);
    }
    public boolean cinema(int id,int passcode){
        return loginService.cinema(id,passcode);
    }
    public boolean admin(int id , int pascode ) {
        if (id==1 & pascode == 1){
            return true;
        }else {
            return false;
        }
    }
}

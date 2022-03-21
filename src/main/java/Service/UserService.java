package Service;

import Entity.Ticket;
import Entity.User;
import repository.UserRepository;

public class UserService {
    UserRepository userRepository = new UserRepository();
    public void buying(int id,int idTicket,int number ){
        try {
            userRepository.buying(id,idTicket,number);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void findById(){}
    public void singUp(User user){
        try {
            userRepository.insertUser(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

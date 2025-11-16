package Service;

import Entities.User;

import java.io.File;

public class UserBookingService {
    private User user;

    private static final String USERPATH="../localDb/users.json";

    UserBookingService(User user){
        this.user=user;
        File users=new File(USERPATH);
    }

}

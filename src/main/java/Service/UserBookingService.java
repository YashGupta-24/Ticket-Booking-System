package Service;

import Entities.Ticket;
import Entities.User;
import Util.UserServiceUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

public class UserBookingService {
    private User user;

    private List<User> userList;

    private static final String USERPATH="../localDb/users.json";

    private ObjectMapper objectMapper=new ObjectMapper();

    UserBookingService(User currUser) throws IOException {
        this.user=currUser;
        File users=new File(USERPATH);
        userList=objectMapper.readValue(users, new TypeReference<List<User>>() {});
    }

    public Boolean loginUser(){
        Optional<User> foundUser=userList.stream().filter(currUser -> {
            return currUser.getName().equalsIgnoreCase(user.getName()) && UserServiceUtil.checkPassword(user.getPassword(), currUser.getHashedPassword());
        }).findFirst();
        return foundUser.isPresent();
    }

    public Boolean signUp(User currUser){
        try{
            userList.add(currUser);
            saveUserToFile();
            return Boolean.TRUE;
        }
        catch(IOException e){
            return Boolean.FALSE;
        }
    }

    private void saveUserToFile() throws  IOException{
        File usersFile=new File(USERPATH);
        objectMapper.writeValue(usersFile, userList);
    }

    public void fetchBookings(){
        user.printTickets();
    }

    //Complete this function
    public boolean deleteBooking(String ticketId){
        Optional<Ticket> currTicket=user.getTicket(ticketId);
        try{
            userList.remove(currTicket);
            saveUserToFile();
            return true;
        }
        catch (IOException e){
            return false;
        }
    }

}

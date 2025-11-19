package Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private String password;
    private String hashedPassword;
    private List<Ticket> ticketsBooked;
    private String userId;

    public void printTickets(){
        for(int i=0;i<ticketsBooked.size();i++){
            System.out.println(ticketsBooked.get(i).getTicketId());
        }
    }

    public Optional<Ticket> getTicket(String ticketId){
        return ticketsBooked.stream().filter(ticket-> Objects.equals(ticket.getTicketId(), ticketId)).findFirst();
    }
}

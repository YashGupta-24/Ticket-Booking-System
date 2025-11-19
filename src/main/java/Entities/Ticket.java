package Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    private String ticketId;
    private String userId;
    private String source;
    private String destination;
    private Date dateOfTravel;
    private Train train;

}

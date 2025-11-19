package Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Train {
    private String trainId;
    private String trainNo;
    private Map<String, Time> stationTimes;
    private List<String> stations;
    private List<List<Integer>> seats;
}

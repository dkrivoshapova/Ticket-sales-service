package rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightDto {
    private String number;
    private String cityDeparture;
    private String cityArrival;
    private String timeDeparture;
    private String timeArrival;
    private String cost;
    private String seats;
    private String daysOfWeek;
    public List<String> dates = new ArrayList<>();
}

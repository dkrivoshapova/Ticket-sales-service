package rest.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String number;

    @Column(name = "citydeparture")
    private String cityDeparture;

    @Column(name = "cityarrival")
    private String cityArrival;

    @Column(name = "timedeparture")
    private String timeDeparture;

    @Column(name = "timearrival")
    private String timeArrival;

    private String cost;

    private String seats;

    @Column(name = "daysofweek")
    private String daysOfWeek;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "flights")
//    private List<Date> dates;
}


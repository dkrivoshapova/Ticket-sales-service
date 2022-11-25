package rest.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "dates")
public class Date {
    @Id
    private Integer id;

    private java.util.Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id")
    private Flight flights;
}

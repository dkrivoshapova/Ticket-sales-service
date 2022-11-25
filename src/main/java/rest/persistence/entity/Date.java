package rest.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Entity // указывает, что данный класс является базой данных
@Data //декоратор который переводит данные из таблицы в строчные значения то же саммое что toString - выводит все в строку,
// фигня равноценная getter
@Table(name = "dates")
public class Date {
    @Id
    private Integer id;

    private java.util.Date date;

    @ManyToOne(fetch = FetchType.LAZY) // тип ключей - один ко многим (В одну дату несколько полетов)
    @JoinColumn(name = "flight_id")
    private Flight flights;
}

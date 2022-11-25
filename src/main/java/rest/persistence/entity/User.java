package rest.persistence.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Data // getter and setter
@Table(name = "userInfo")
public class User {
    @Id
    private int id;
    private String email;
    private String password;
}
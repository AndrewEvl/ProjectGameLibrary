package entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by User on 23.05.2017.
 */
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Column (name = "name")
    @Setter
    @Getter
    private String name;
    @Column (name = "nickname")
    @Setter
    @Getter
    private String nickName;
    @Column (name = "birthday")
    @Setter
    @Getter
    private LocalDate date;
    @Column (name = "password")
    @Setter
    @Getter
    private String password;
    @Column (name = "mail")
    @Setter
    @Getter
    private String mail;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;
//    @Column (name = "review")
//    @Setter
//    @Getter
//    private String role;
}

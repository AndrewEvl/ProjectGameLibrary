package entity;

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
public class User extends BaseEntity {
    @Column(name = "name")
    @Setter
    @Getter
    private String name;
    @Column(name = "nickname")
    @Setter
    @Getter
    private String nickName;
    @Column(name = "birthday")
    @Setter
    @Getter
    private LocalDate date;
    @Column(name = "password")
    @Setter
    @Getter
    private String password;
    @Column(name = "mail")
    @Setter
    @Getter
    private String mail;
    @OneToOne
    @JoinColumn(name = "roles_users_id")
    @Setter
    @Getter
    private Role role;
    @Getter
    @Setter
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "city")),
            @AttributeOverride(name = "country", column = @Column(name = "country"))
    })
    private Address address;

    public User(String name, String nickName, LocalDate date, String password, String mail, Role role, Address address) {
        this.name = name;
        this.nickName = nickName;
        this.date = date;
        this.password = password;
        this.mail = mail;
        this.role = role;
        this.address = address;
    }
}

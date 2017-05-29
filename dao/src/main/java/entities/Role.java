package entities;

import lombok.*;

import javax.persistence.*;

/**
 * Created by User on 29.05.2017.
 */
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;
    @Column (name = "roles")
    @Setter
    @Getter
    private String role;
}

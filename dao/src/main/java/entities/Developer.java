package entities;

import lombok.*;
import javax.persistence.*;

/**
 * Created by User on 23.05.2017.
 */
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "developers")
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @Column (name = "name")
    @Setter
    @Getter
    private String name;

}

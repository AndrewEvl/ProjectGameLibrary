package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by User on 24.05.2017.
 */
@Entity
@ToString
@NoArgsConstructor
@Table(name = "emploees")
public class Emploees {

    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

}

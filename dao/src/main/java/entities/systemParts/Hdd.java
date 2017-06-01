package entities.systemParts;

import lombok.*;

import javax.persistence.*;

/**
 * Created by User on 29.05.2017.
 */
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "hdd")
public class Hdd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;
    @Column(name = "name")
    @Setter
    @Getter
    private String name;
}
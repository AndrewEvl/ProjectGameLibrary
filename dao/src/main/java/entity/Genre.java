package entity;

import lombok.*;

import javax.persistence.*;

/**
 * Created by User on 23.05.2017.
 */
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;
    @Column (name = "genre")
    @Setter
    @Getter
    private String name;

    public Genre(String name) {
        this.name = name;
    }
}

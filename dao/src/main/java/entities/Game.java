package entities;

import lombok.*;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 23.05.2017.
 */
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "games")
public class Game {
    @Column (name = "name")
    @Setter
    @Getter
    private String name;
//    @Column (name = "release_day")
//    @Setter
//    @Getter
//    private LocalDate releaseDay;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;
//    @Setter
//    @Getter
//    private Genre genre;
//    @Column (name = "name")
//    @Setter
//    @Getter
//    private Publisher publisher;
//    @Column (name = "name")
//    @Setter
//    @Getter
//    private Developer developer;
//    @Column (name = "name")
//    @Setter
//    @Getter
//    private Set<Review> review = new HashSet<Review>();

}

package entities;

import entities.Reviews.ReviewGame;
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

   @Column (name = "release_day")
    @Setter
    @Getter
    private LocalDate releaseDay;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @ManyToOne (cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn (name = "genres_id")
    @Setter
    @Getter
    private Genre genre;

    @ManyToOne (cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn (name = "publishers_id")
    @Setter
    @Getter
    private Publisher publisher;

    @ManyToOne (cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn (name = "developers_id")
    @Setter
    @Getter
    private Developer developer;

    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "game")
    @Setter
    @Getter
    private Set<ReviewGame> reviewGame = new HashSet<>();

}

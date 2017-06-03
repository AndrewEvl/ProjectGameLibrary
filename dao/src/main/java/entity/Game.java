package entity;

import entity.reviews.ReviewGame;
import lombok.*;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 23.05.2017.
 */
@Entity
@ToString(exclude = "reviewGame")
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "games")
public class Game {

    @Column(name = "name")
    @Setter
    @Getter
    private String name;

    @Column(name = "release_day")
    @Setter
    @Getter
    private LocalDate releaseDay;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "genres_id")
    @Setter
    @Getter
    private Genre genre;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "publishers_id")
    @Setter
    @Getter
    private Publisher publisher;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "developers_id")
    @Setter
    @Getter
    private Developer developer;

    @OneToMany(mappedBy = "game")
    @Setter
    @Getter
    private Set<ReviewGame> reviewGame = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "game_platforms_system",
            joinColumns = @JoinColumn(name = "platform_system_id"),
            inverseJoinColumns = @JoinColumn(name = "games_id"))
    @Setter
    @Getter
    private Set<SystemSetting> systemSetting = new HashSet<>();

}

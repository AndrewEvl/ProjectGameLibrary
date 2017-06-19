package entity;

import entity.reviews.ReviewGame;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 23.05.2017.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@Table(name = "games")
@ToString(exclude = {"reviewGame", "platform"}, callSuper = true)
public class Game extends BaseEntity {

    @Column(name = "name")
    @Setter
    @Getter
    private String name;

    @Column(name = "release_day")
    @Setter
    @Getter
    private LocalDate releaseDay;

    @ManyToOne
    @JoinColumn(name = "genres_id")
    @Setter
    @Getter
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "publishers_id")
    @Setter
    @Getter
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "developers_id")
    @Setter
    @Getter
    private Developer developer;

    @OneToMany(mappedBy = "game")
    @Setter
    @Getter
    private Set<ReviewGame> reviews = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "game_platforms_system",
            joinColumns = @JoinColumn(name = "games_id"),
            inverseJoinColumns = @JoinColumn(name = "platform_system_id"))
    @Setter
    @Getter
    private Set<Platform> platforms = new HashSet<>();

    public Game(String name, LocalDate releaseDay, Genre genre, Publisher publisher, Developer developer) {
        this.name = name;
        this.releaseDay = releaseDay;
        this.genre = genre;
        this.publisher = publisher;
        this.developer = developer;
    }

    public Game(String name, LocalDate releaseDay, Genre genre, Publisher publisher, Developer developer, Set<ReviewGame> reviews, Set<Platform> platforms) {
        this.name = name;
        this.releaseDay = releaseDay;
        this.genre = genre;
        this.publisher = publisher;
        this.developer = developer;
        this.reviews = reviews;
        this.platforms = platforms;
    }


}

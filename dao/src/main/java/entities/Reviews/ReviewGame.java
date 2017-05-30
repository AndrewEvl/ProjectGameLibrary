package entities.Reviews;

import entities.Game;
import lombok.*;

import javax.persistence.*;

/**
 * Created by User on 23.05.2017.
 */
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "reviews_game")
public class ReviewGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column (name = "review")
    @Setter
    @Getter
    private String text;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable(name = "games",joinColumns =  @JoinColumn(name = "reviews_id"),
    inverseJoinColumns = @JoinColumn(name = "id"))
    private Game game;
}

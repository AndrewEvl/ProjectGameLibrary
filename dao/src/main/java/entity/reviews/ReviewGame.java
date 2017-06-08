package entity.reviews;

import entity.Game;
import lombok.*;

import javax.persistence.*;

/**
 * Created by User on 23.05.2017.
 */
@Entity
@ToString (exclude = "game")
@EqualsAndHashCode(exclude = "game")
@NoArgsConstructor
@Table(name = "reviews_game")
public class ReviewGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(name = "review")
    @Setter
    @Getter
    private String text;

    @ManyToOne
    @JoinColumn(name = "games_id")
    @Setter
    @Getter
    private Game game;

    public ReviewGame(String text) {
        this.text = text;
    }

}

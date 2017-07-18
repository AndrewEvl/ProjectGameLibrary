package entity;

import lombok.*;

import javax.persistence.*;

/**
 * Created by User on 08.06.2017.
 */
@Entity
@Table(name = "game_collections")
@ToString(callSuper = true)
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "game_id")
public class GameCollection extends Game {

    @Getter
    @Setter
    @Column(name = "figure")
    private String figure;

    @Getter
    @Setter
    @Column(name = "artbook")
    private String artBook;

    @Getter
    @Setter
    @Column(name = "ost")
    private String ost;

    @Getter
    @Setter
    @Column(name = "other")
    private String other;
}

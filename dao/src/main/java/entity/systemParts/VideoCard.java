package entity.systemParts;

import lombok.*;

import javax.persistence.*;

/**
 * Created by User on 29.05.2017.
 */
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "video_card")
public class VideoCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;
    @Column(name = "name")
    @Setter
    @Getter
    private String name;

    public VideoCard(String name) {
        this.name = name;
    }
}

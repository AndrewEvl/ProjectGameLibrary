package entity.systemParts;

import entity.BaseEntity;
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
public class VideoCard extends BaseEntity {

    @Column(name = "name")
    @Setter
    @Getter
    private String name;

    public VideoCard(String name) {
        this.name = name;
    }
}

package entity;

import entity.reviews.ForumComments;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by User on 23.05.2017.
 */
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "forum_theme")

public class ForumTheme extends BaseEntity {

    @Column(name = "theme")
    @Setter
    @Getter
    private String theme;

    @OneToMany(mappedBy = "forumTheme")
    @Setter
    @Getter
    private Set<ForumComments> forumComments;

    public ForumTheme(String theme) {
        this.theme = theme;
    }
}

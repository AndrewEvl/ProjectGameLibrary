package entity.reviews;

import entity.BaseEntity;
import entity.ForumTheme;
import entity.User;
import lombok.*;

import javax.persistence.*;

/**
 * Created by User on 06.06.2017.
 */
@Entity
@ToString(exclude = "forumTheme")
@NoArgsConstructor
@Table(name = "comments_forum")
public class ForumComments extends BaseEntity {

    @Column(name = "name")
    @Setter
    @Getter
    private String name;

    @ManyToOne
    @JoinColumn(name = "forum_theme_id")
    @Setter
    @Getter
    private ForumTheme forumTheme;

    @OneToOne
    @JoinColumn(name = "user_id")
    @Setter
    @Getter
    private User user;
}

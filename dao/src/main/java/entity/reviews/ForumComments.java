package entity.reviews;

import entity.ForumTheme;
import entity.User;
import lombok.*;

import javax.persistence.*;

/**
 * Created by User on 06.06.2017.
 */
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "comments_forum")
public class ForumComments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
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

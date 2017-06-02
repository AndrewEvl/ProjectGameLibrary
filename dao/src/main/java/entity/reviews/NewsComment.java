package entity.reviews;

import entity.News;
import lombok.*;

import javax.persistence.*;

/**
 * Created by User on 30.05.2017.
 */
@Entity
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "comments_news")
public class NewsComment {
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
    @JoinColumn (name = "news_id")
    @Setter
    @Getter
    private News setNews;
}

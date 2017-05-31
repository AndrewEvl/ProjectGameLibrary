package entities.Reviews;

import entities.News;
import lombok.*;

import javax.persistence.*;

/**
 * Created by User on 30.05.2017.
 */
@Entity
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "reviews_news")
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

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable(name = "news_reviews_news", joinColumns = @JoinColumn(name = "news_id"),
            inverseJoinColumns = @JoinColumn(name = "reviews_news_id"))
    @Setter
    @Getter
    private News setNews;
}

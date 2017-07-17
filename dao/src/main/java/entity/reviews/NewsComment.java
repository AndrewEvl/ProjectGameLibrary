package entity.reviews;

import entity.BaseEntity;
import entity.News;
import entity.User;
import lombok.*;

import javax.persistence.*;

/**
 * Created by User on 30.05.2017.
 */
@Entity
@ToString
@NoArgsConstructor
@Table(name = "comments_news")
public class NewsComment extends BaseEntity {

    @Column(name = "review")
    @Setter
    @Getter
    private String text;

    @ManyToOne
    @JoinColumn (name = "news_id")
    @Setter
    @Getter
    private News setNews;

    public NewsComment(String text) {
        this.text = text;
    }

}

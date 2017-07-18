package entity;

import entity.reviews.NewsComment;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 23.05.2017.
 */
@Entity
@ToString(exclude = "newsCommentSet", callSuper = true)
@NoArgsConstructor
@Table(name = "news")
public class News extends BaseEntity {
    @Column(name = "name")
    @Setter
    @Getter
    private String name;

    @Version
    @Getter
    @Setter
    private Long version;

    @Column(name = "date")
    @Setter
    @Getter
    private LocalDate date;

    @Column(name = "text")
    @Setter
    @Getter
    private String text;

    @OneToMany(mappedBy = "setNews", fetch = FetchType.EAGER)
    @Setter
    @Getter
    private Set<NewsComment> newsCommentSet = new HashSet<>();

    public News(String name, LocalDate date, String text) {
        this.name = name;
        this.date = date;
        this.text = text;
    }

    public News(String name, LocalDate date, String text, Set<NewsComment> newsCommentSet) {
        this.name = name;
        this.date = date;
        this.text = text;
        this.newsCommentSet = newsCommentSet;
    }
}

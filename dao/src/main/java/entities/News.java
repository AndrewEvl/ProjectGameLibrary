package entities;

import entities.reviews.NewsComment;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 23.05.2017.
 */
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "news")

public class News {
    @Column (name = "name")
    @Setter
    @Getter
    private String name;

    @Column (name = "date")
    @Setter
    @Getter
    private LocalDate date;

    @Column (name = "text")
    @Setter
    @Getter
    private String text;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @OneToMany (mappedBy = "setNews")
    @Setter
    @Getter
    private Set<NewsComment> newsCommentSet = new HashSet<>();

}

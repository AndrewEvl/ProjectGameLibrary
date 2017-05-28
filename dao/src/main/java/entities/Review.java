package entities;

import lombok.*;

import javax.persistence.*;

/**
 * Created by User on 23.05.2017.
 */
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;
    @Column (name = "review")
    @Setter
    @Getter
    private String text;
}

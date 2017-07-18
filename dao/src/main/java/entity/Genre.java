package entity;

import lombok.*;

import javax.persistence.*;

/**
 * Created by User on 23.05.2017.
 */
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "genres")
public class Genre extends BaseEntity {

    @Column(name = "genre")
    @Setter
    @Getter
    private String name;

    public Genre(String name) {
        this.name = name;
    }
}

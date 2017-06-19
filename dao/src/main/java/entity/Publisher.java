package entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by User on 23.05.2017.
 */
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "publishers")
public class Publisher extends BaseEntity {

    @Column (name = "name")
    @Setter
    @Getter
    private String name;

    public Publisher(String name) {
        this.name = name;
    }
}

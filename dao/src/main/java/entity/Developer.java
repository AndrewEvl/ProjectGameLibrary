package entity;

import lombok.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by User on 23.05.2017.
 */
@Entity
@ToString
@NoArgsConstructor
@Table(name = "developers")
public class Developer extends BaseEntity {

    @Column (name = "name")
    @Setter
    @Getter
    private String name;

    public Developer(String name) {
        this.name = name;
    }
}

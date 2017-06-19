package entity.systemParts;

import entity.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by User on 29.05.2017.
 */
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "hdd")
public class Hdd extends BaseEntity {

    @Column(name = "name")
    @Setter
    @Getter
    private String name;

    public Hdd(String name) {
        this.name = name;
    }
}

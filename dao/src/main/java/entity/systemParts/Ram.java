package entity.systemParts;

import entity.BaseEntity;
import lombok.*;

import javax.persistence.*;

/**
 * Created by User on 29.05.2017.
 */
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "ram")
public class Ram extends BaseEntity {

    @Column(name = "name")
    @Setter
    @Getter
    private String name;

    public Ram(String name) {
        this.name = name;
    }
}

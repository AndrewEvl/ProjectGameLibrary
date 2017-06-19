package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by User on 23.05.2017.
 */
@Entity
@NoArgsConstructor
@Table(name = "platforms")
public class Platform extends BaseEntity {

    @Column (name = "name")
    @Setter
    @Getter
    private String name;

    @ManyToOne (cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn
    @Setter
    @Getter
    private SystemSetting systemSetting;

    public Platform(String name, SystemSetting systemSetting) {
        this.name = name;
        this.systemSetting = systemSetting;
    }
}

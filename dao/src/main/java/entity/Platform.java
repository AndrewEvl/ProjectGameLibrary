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
@Table(name = "platforms")
public class Platform {

    @Column (name = "name")
    @Setter
    @Getter
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;
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

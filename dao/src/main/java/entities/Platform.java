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
    @JoinTable(name = "platforms_system",
    joinColumns = @JoinColumn (name = "platforms_id"),
    inverseJoinColumns = @JoinColumn(name = "system_settings_id"))
    @Setter
    @Getter
    private SystemSetting systemSetting;
}

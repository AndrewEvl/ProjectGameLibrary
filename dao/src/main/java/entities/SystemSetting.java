package entities;

import entities.systemParts.Cpu;
import entities.systemParts.Hdd;
import entities.systemParts.Ram;
import entities.systemParts.VideoCard;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 23.05.2017.
 */
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "system_requirements")
public class SystemSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;
    @OneToOne
    @JoinColumn(name = "cpu_id")
    @Setter
    @Getter
    private Cpu cpu;
    @OneToOne
    @JoinColumn(name = "ram_id")
    @Setter
    @Getter
    private Ram ram;
    @OneToOne
    @JoinColumn(name = "hdd_id")
    @Setter
    @Getter
    private Hdd hdd;
    @OneToOne
    @JoinColumn(name = "video_card_id")
    @Setter
    @Getter
    private VideoCard videoCard;
    @ManyToMany(mappedBy = "systemSetting")
    @Setter
    @Getter
    private Set<Game> game = new HashSet<>();
}

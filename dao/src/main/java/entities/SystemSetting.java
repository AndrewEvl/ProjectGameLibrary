package entities;

import entities.SystemParts.Cpu;
import entities.SystemParts.Hdd;
import entities.SystemParts.Ram;
import entities.SystemParts.VideoCard;
import lombok.*;

import javax.persistence.*;

/**
 * Created by User on 23.05.2017.
 */
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "system_settings")
public class SystemSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "cpu_id")
    @Setter
    @Getter
    private Cpu cpu;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "ram_id")
    @Setter
    @Getter
    private Ram ram;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "hdd_id")
    @Setter
    @Getter
    private Hdd hdd;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "video_card_id")
    @Setter
    @Getter
    private VideoCard videoCard;
}

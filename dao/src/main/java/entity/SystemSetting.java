package entity;

import entity.systemParts.Cpu;
import entity.systemParts.Hdd;
import entity.systemParts.Ram;
import entity.systemParts.VideoCard;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 23.05.2017.
 */
@Entity
@ToString (exclude = "game")
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "system_requirements")
public class SystemSetting extends BaseEntity {

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
    @ManyToMany(mappedBy = "platform")
    @Setter
    @Getter
    private Set<Game> game = new HashSet<>();

    public SystemSetting(Cpu cpu, Ram ram, Hdd hdd, VideoCard videoCard) {
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
        this.videoCard = videoCard;
    }
}

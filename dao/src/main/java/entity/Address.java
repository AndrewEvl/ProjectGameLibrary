package entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by User on 06.06.2017.
 */
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
    @Getter
    @Setter
    @Column(name = "city")
    private String city;
    @Getter
    @Setter
    @Column(name = "country")
    private String country;
}

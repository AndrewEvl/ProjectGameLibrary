package dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by Lino on 15.07.2017.
 */
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class GameDto {

    private String nameGame;
    private Long genreId;
    private Long publisherId;
    private Long developerId;
    private Long platforms;
}

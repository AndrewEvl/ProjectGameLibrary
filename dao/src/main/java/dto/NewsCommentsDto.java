package dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by User on 17.07.2017.
 */
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class NewsCommentsDto {

    private String text;
    private Long idNews;
    private Long idUser;

}

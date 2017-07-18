package dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by Lino on 18.07.2017.
 */
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class NewsDto {

    private String nameNews;
    private String textNews;
}

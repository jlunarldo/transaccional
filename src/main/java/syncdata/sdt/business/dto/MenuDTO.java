package syncdata.sdt.business.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuDTO {

    private long id_menu;
    private String flowName;
    private String urlComponent;
    private String nameComponent;
}

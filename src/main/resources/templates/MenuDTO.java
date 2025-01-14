package syncdata.sdt.business.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RequiredArgsConstructor
public class MenuDTO {

    private Long id_menu;
    private String flowName;
    private String urlComponent;
    private String nameComponent;
}

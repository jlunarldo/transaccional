package syncdata.sdt.business.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class RolDTO {

    private long id_rol;
    private long id_menu;
    //private menu rol_menu;
    private String name;
}

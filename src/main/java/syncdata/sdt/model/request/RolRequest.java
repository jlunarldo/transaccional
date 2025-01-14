package syncdata.sdt.model.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RolRequest {

    public static final String MSG_NOT_EMPTY= "No se puede crear sin valor.";

    private long id_rol;

    @Min(value = 1, message = MSG_NOT_EMPTY)
    private long id_menu;

    @NotNull(message = MSG_NOT_EMPTY)
    private String name;
}

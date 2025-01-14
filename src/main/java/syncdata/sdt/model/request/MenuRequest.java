package syncdata.sdt.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MenuRequest {

    public static final String MSG_NOT_EMPTY= "No se puede crear sin valor.";

    private Long id_menu;

    @NotNull(message = MSG_NOT_EMPTY)
    private String flowName;

    @NotNull(message = MSG_NOT_EMPTY)
    private String urlComponent;

    @NotNull(message = MSG_NOT_EMPTY)
    private String nameComponent;
}

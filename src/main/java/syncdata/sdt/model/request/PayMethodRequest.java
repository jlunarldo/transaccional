package syncdata.sdt.model.request;


import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PayMethodRequest {

    public static final String MSG_NOT_EMPTY= "No se puede crear sin valor.";

    private long id_pay;

    @NotNull(message = MSG_NOT_EMPTY)
    private String nameMethod;

    @NotNull(message = MSG_NOT_EMPTY)
    private String entityType;

}

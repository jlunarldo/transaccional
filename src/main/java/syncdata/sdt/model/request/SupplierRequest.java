package syncdata.sdt.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SupplierRequest {

    public static final String MSG_NOT_EMPTY= "No se puede crear sin valor.";

    private long id_supplier;

    @NotNull(message = MSG_NOT_EMPTY)
    private String nameBusiness;

    @Email(message = "Tiene que tener formato de email")
    @NotNull(message = MSG_NOT_EMPTY)
    private String email;

    @NotNull(message = MSG_NOT_EMPTY)
    private String docIdentityB;

    @NotNull(message = MSG_NOT_EMPTY)
    private String docTypeB;

    @NotNull(message = MSG_NOT_EMPTY)
    private String categorie;

    @NotNull(message = MSG_NOT_EMPTY)
    private String legalRepresentative;

    @NotNull(message = MSG_NOT_EMPTY)
    private String docTdentityR;

    @NotNull(message = MSG_NOT_EMPTY)
    private String docTypeR;
}

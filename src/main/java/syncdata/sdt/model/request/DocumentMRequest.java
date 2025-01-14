package syncdata.sdt.model.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)

public class DocumentMRequest {

    public static final String MSG_NOT_EMPTY= "No se puede crear sin valor.";
    @Positive
    private long id_documentM;

    @NotEmpty(message = MSG_NOT_EMPTY)
    private String nameDocumentM;

}

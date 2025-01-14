package syncdata.sdt.model.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ClientRequest {
    public static final String MSG_NOT_EMPTY= "No se puede crear sin valor.";

    private long id;

    @NotEmpty(message = MSG_NOT_EMPTY)
    private String fullName;

    @NotEmpty(message = MSG_NOT_EMPTY)
    private String email;

    @NotEmpty(message = MSG_NOT_EMPTY)
    private String docIdentity;

    @NotEmpty(message = MSG_NOT_EMPTY)
    private String docType;


    private String street;


    private long phoneNumber;


    private Date birthday;  // java.util.Date es recomendado si no necesitas timestamps


    private Integer flag;


    private Timestamp registerDate;
}

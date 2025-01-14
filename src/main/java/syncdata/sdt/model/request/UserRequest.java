package syncdata.sdt.model.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserRequest {

    public static final String MSG_NOT_EMPTY= "No se puede crear sin valor.";

    private long id_user;
    @Min(value = 1, message = MSG_NOT_EMPTY)
    //@NotNull(message = MSG_NOT_EMPTY) //problema que si le llega a Java, lo transforma a 0 de una. Tendríamos que ponerle Long ya que con esté tipo de dato si no le llega nada Java le pone x defecto NULL
    @NotNull
    private Long id_rol;

    @NotNull(message = MSG_NOT_EMPTY)
    private String fullName;

    @NotNull(message = MSG_NOT_EMPTY)
    private String docIdentity;

    @Email(message = MSG_NOT_EMPTY)
    private String email;


    @NotEmpty(message = MSG_NOT_EMPTY)
    private String userName;

    @NotEmpty(message = MSG_NOT_EMPTY)
    private String password;

    private long phoneNumber; // or Integer if phonenumber values are within the Integer range
    private long age;  // or Integer if age values are within the Integer range
    private String street;
    private Date birthday;
}

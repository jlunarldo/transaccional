package syncdata.sdt.business.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import syncdata.sdt.business.entities.Rol;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserGeneralDTO {
    private long id_user;

    private long id_rol;

    private String fullName;
    private String docIdentity;
    private Long age;  // or Integer if age values are within the Integer range
    private String street;
    private Date birthday;
    private String email;
    private long phoneNumber; // or Integer if phonenumber values are within the Integer range
    private String userName;
    private String password;
}

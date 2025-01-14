package syncdata.sdt.business.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Date; // ?
import java.sql.Timestamp;
@Entity
@Table(name="USER_GENERAL")
@Getter
@Setter
@RequiredArgsConstructor
public class UserGeneral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USER")
    private  long id_user;


    private long id_rol;

    @Column(name = "FULLNAME")
    private String fullName;

    @Column(name = "DOCIDENTITY")
    private String docIdentity;

    @Column(name = "REGISTERDATE")
    private Timestamp registerDate;

    @Column(name = "AGE")
    private long age;  // Puedes cambiarlo a Integer si es necesario

    @Column(name = "STREET")
    private String street;

    @Column(name = "BIRTHDAY")
    private Date birthday;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONENUMBER")
    private long phoneNumber; // Puedes cambiarlo a Integer si es necesario

    @Column(name = "USERNAME")
    private String userName;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "FLAG")
    private Integer flag; // assuming flag values are 0 or 1

}

package syncdata.sdt.business.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name="CLIENT")
@Getter
@Setter
@RequiredArgsConstructor
public class Client implements Serializable {
    @Id
    private Long id_client;


    @Column(name = "FULLNAME")
    private String fullName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "DOCIDENTITY")
    private String docIdentity;

    @Column(name = "DOCTYPE")
    private String docType;

    @Column(name = "STREET")
    private String street;

    @Column(name = "PHONENUMBER")
    private Long phoneNumber;

    @Column(name = "BIRTHDAY")
    private Date birthday;  // java.util.Date es recomendado si no necesitas timestamps

    @Column(name = "FLAG")
    private Integer flag;

    @Column(name = "REGISTERDATE")
    private Timestamp registerDate;

}

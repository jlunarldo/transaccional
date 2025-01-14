package syncdata.sdt.business.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name="SUPPLIER")
@Getter
@Setter
@RequiredArgsConstructor
public class Supplier {
    //DATOS DE LA EMPRESA
    @Id
    private Long id_supplier;


    @Column(name = "NAMEBUSINESS")
    private String nameBusiness;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "DOCIDENTITYB")
    private String docIdentityB;

    @Column(name = "DOCTYPEB")
    private String docTypeB;

    @Column(name = "STREET")
    private String street;

    @Column(name = "CATEGORIE")
    private String categorie;

    @Column(name = "PHONENUMBERB")
    private Long phoneNumberB;

    // Aunque este campo es de tipo "Date", dado que representa una empresa, podrías reconsiderar su uso si no es necesario para el contexto.
    @Column(name = "BIRTHDAY")
    private Date birthday;  // java.util.Date es lo recomendado para fechas que no impliquen timestamp

    @Column(name = "LEGALREPRESENTATIVE")
    private String legalRepresentative;

    @Column(name = "DOCTDENTITYR")
    private String docTdentityR;

    @Column(name = "DOCTYPE_R")
    private String docTypeR;

    @Column(name = "FLAG")
    private Integer flag;


    @Column(name = "REGISTERDATE")
    private Timestamp registerDate;
    //private List<sell> listSell;
}

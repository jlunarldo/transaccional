package syncdata.sdt.business.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@RequiredArgsConstructor
public class SupplierDTO { //chequear con Joao si esto lo dvininos en SUplierBusinessDTO y SUplierRepresentativeDTO

    private long id_supplier;
    private String nameBusiness;
    private String email;
    private String docIdentityB;
    private String docTypeB;
    private String street;
    private String categorie;
    private long phoneNumberB;
    private Date birthday; //java util o java sql? ,  PQ TIENE BITHDAY UNA EMPRESA
    //TODOS DATOS DEL REPRESENTANTE LEGAL DE LA MEPRESA
    private String legalRepresentative;
    private String docTdentityR;
    private String docTypeR;

}

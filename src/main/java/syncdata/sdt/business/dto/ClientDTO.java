package syncdata.sdt.business.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
public class ClientDTO {

    private long id_client;
    private String fullName;
    private String docIdentity;
    private String docType;
    private String street;
}

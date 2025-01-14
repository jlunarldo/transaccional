package syncdata.sdt.business.dto;


import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor

public class PayMethodDTO {

    private long id_pay;
    private String nameMethod;
    private String entityType;



}

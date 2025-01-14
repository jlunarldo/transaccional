package syncdata.sdt.business.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BuyDTO {

    private long id_buy;
    private long id_user;
    private long id_client;
    private long id_docM;
    private long id_payMethod;
    private long id_product;

    private Float priceBefore;
    private Float priceFinally;
    private Integer status;
}

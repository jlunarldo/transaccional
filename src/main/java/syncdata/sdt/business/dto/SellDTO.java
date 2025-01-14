package syncdata.sdt.business.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SellDTO {

    private long id_sell;

    private long id_user;
    private long id_client;
    private long id_docM;
    private long id_payMethod;
    private long id_product;

    private Float priceBefore;
    private Float priceFinally;
    private Integer status;

}

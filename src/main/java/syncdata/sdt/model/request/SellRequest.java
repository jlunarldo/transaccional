package syncdata.sdt.model.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)

public class SellRequest {

    public static final String MSG_NOT_EMPTY= "No se puede crear sin valor.";

    private long id_sell;
    @Min(value = 1, message = MSG_NOT_EMPTY)

    private long id_user;
    @Min(value = 1, message = MSG_NOT_EMPTY)
    private long id_client;

    @Min(value = 1, message = MSG_NOT_EMPTY)
    private long id_docM;

    @Min(value = 1, message = MSG_NOT_EMPTY)
    private long id_payMethod;

    @Min(value = 1, message = MSG_NOT_EMPTY)
    private long id_product;

    @Positive(message="No puede ir negativo")
    private Float priceFinally;

    private Float priceBefore;

    private Integer status;

}

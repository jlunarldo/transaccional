package syncdata.sdt.model.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProductRequest {

    public static final String MSG_NOT_EMPTY= "No se puede crear sin valor.";


    private long id_product;

    @NotEmpty(message = MSG_NOT_EMPTY)
    private String nameProduct;

    @NotEmpty(message = MSG_NOT_EMPTY)
    private String categorie;

    @Min(value = 1, message = MSG_NOT_EMPTY)
    @Max(value= 999, message = MSG_NOT_EMPTY)
    private long cantTotal;

    @PositiveOrZero(message = MSG_NOT_EMPTY)
    private long priceTotal;
}

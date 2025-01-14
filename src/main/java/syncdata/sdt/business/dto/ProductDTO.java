package syncdata.sdt.business.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ProductDTO {

    private long id_product;
    private String nameProduct;
    private String categorie;
    private long cantTotal;
    private long priceTotal;
}
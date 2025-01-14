package syncdata.sdt.business.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name="PRODUCT")
@Getter
@Setter
@RequiredArgsConstructor
public class Product {
    @Id
    private Long id_product;

    @Column(name = "NAMEPRODUCT")
    private String nameProduct;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CATEGORIE")
    private String categorie;

    @Column(name = "SUBCATEGORIE")
    private String subCategorie;

    @Column(name = "CANTTOTAL")
    private Long cantTotal;

    @Column(name = "PRICEUNIT")
    private Float priceUnit;

    @Column(name = "PRICETOTAL")
    private Long priceTotal;

    @Column(name = "FLAG")
    private Integer flag;


    @Column(name = "REGISTERDATE")
    private Timestamp registerDate;
}

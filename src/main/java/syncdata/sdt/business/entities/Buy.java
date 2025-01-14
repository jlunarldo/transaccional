package syncdata.sdt.business.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name="BUY")
@Getter
@Setter
@RequiredArgsConstructor

public class Buy implements Serializable {

    @Id
    private Long id_buy;
    @JsonIgnore
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id_user", nullable = false)
    private UserGeneral user;

    @JsonIgnore
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id_client", nullable = false)
    private Client client;

    @JsonIgnore
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id_documentM", nullable = false)

    private DocumentMercantil docM;

    @JsonIgnore
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id_pay", nullable = false)
    private PayMethod payMethod;

    @JsonIgnore
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id_product", nullable = false)
    private Product product;

    @Column(name = "PRICEBEFORE")
    private Float priceBefore;

    @Column(name = "PRICEFINALLY")
    private Float priceFinally;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "FLAG")
    private Integer flag;

    @Column(name = "REGISTERDATE")
    private Timestamp registerDate;





}

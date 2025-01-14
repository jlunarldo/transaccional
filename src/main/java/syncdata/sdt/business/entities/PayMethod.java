package syncdata.sdt.business.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name="PAY_METHOD")
public class PayMethod {
    @Id
    private Long id_pay;


    @Column(name = "NAMEMETHOD")
    private String nameMethod;

    @Column(name = "ENTITYTYPE")
    private String entityType;

    @Column(name = "FLAG")
    private Integer flag;


    @Column(name = "REGISTERDATE")
    private Timestamp registerDate;
}

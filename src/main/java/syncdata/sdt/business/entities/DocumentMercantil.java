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
@Getter
@Setter
@RequiredArgsConstructor
@Table(name="DOCUMENT_MERCANTIL")
public class DocumentMercantil {
    @Id
    private Long id_documentM;

    @Column(name = "NAMEDOCUMENTM")
    private String nameDocumentM;

    @Column(name = "FLAG")
    private Integer flag;

    @Column(name = "REGISTERDATE")
    private Timestamp registerDate;

}

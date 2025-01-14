package syncdata.sdt.business.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name="ROL")
@Getter
@Setter
@RequiredArgsConstructor
public class Rol {
    @Id
    private Long id_rol;

    @JsonIgnore
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id_menu", nullable = false)
    private Menu menu;

    @Column(name = "REGISTERDATE")
    private Timestamp registerDate;

    @Column(name = "NAME")
    private String name;

    @Column(name = "FLAG")
    private Integer flag;


}

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
@Table(name="MENU")
@Getter
@Setter
@RequiredArgsConstructor
public class Menu {
    @Id
    private Long id_menu;

    @Column(name = "FLOWNAME")
    private String flowName;

    @Column(name = "URLCOMPONENT")
    private String urlComponent;

    @Column(name = "NAMECOMPONENT")
    private String nameComponent;

    @Column(name = "FLAG")
    private Integer flag;

    @Column(name = "REGISTERDATE")
    private Timestamp registerDate;
}

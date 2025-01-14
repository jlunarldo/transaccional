package syncdata.sdt.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import syncdata.sdt.business.entities.Menu;
import syncdata.sdt.business.entities.UserGeneral;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    /*@Query("SELECT d FROM MENU d WHERE LOWER(d.flowName) LIKE LOWER(CONCAT('%', :keyword,'%'))"
            + " AND  d.flag = 1")
    List<Menu> getByFlowName(@Param("keyword") String keyword);
    @Query("SELECT d FROM MENU d WHERE CAST(d.flag AS string) LIKE CONCAT('%', :keyword, '%') ")
    List<Menu> getByFlag(@Param("keyword") String keyword);*/
}
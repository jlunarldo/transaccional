package syncdata.sdt.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import syncdata.sdt.business.entities.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT DISTINCT d.categorie FROM Product d WHERE d.categorie IS NOT NULL")
    List<String> getAllUniqueCategories();
    //SELECT d FROM UserGeneral d WHERE LOWER(d.fullName) LIKE LOWER(CONCAT('%', :keyword,'%'))"
    //            + " AND  d.flag = 1
    //@Query("SELECT d FROM Product d WHERE LOWER(d.categorie) LIKE LOWER(CONCAT('%', :keyword,'%')")
    @Query("SELECT d FROM Product d WHERE d.categorie=:keyword")
    List<Product> findByCategorie(@Param("keyword") String keyword);

}
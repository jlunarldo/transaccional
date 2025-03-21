package syncdata.sdt.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import syncdata.sdt.business.entities.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT DISTINCT d.categorie FROM Product d WHERE d.categorie IS NOT NULL")
    List<String> getAllUniqueCategories();

    @Query("SELECT d FROM Product d WHERE d.categorie = :categorie")
    List<Product> findByCategorie(@Param("categorie") String categorie);

}
package syncdata.sdt.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import syncdata.sdt.business.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
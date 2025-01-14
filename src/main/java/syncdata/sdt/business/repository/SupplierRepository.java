package syncdata.sdt.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import syncdata.sdt.business.entities.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
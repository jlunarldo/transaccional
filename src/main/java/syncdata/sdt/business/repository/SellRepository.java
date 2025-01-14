package syncdata.sdt.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import syncdata.sdt.business.entities.Sell;

public interface SellRepository extends JpaRepository<Sell, Long> {
}
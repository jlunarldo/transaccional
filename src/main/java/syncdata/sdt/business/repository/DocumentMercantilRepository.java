package syncdata.sdt.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import syncdata.sdt.business.entities.DocumentMercantil;

public interface DocumentMercantilRepository extends JpaRepository<DocumentMercantil, Long> {
}
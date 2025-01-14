
package syncdata.sdt.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import syncdata.sdt.business.entities.PayMethod;

public interface PayMethodRepository extends JpaRepository<PayMethod, Long> {
}

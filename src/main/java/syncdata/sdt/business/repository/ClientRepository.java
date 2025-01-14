package syncdata.sdt.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import syncdata.sdt.business.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}

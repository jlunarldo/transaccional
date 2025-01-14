package syncdata.sdt.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import syncdata.sdt.business.entities.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {
}
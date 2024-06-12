package groupe3.compagnieAerienne.repository;

import groupe3.compagnieAerienne.model.Vol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolRepo extends JpaRepository<Vol, Long> {
}

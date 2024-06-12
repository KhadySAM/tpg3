package groupe3.compagnieAerienne.repository;

import groupe3.compagnieAerienne.model.Avion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvionRepo extends JpaRepository <Avion, Long> {
    Avion findByMatricule(String matricule);
}

package groupe3.compagnieAerienne.repository;

import groupe3.compagnieAerienne.model.Voyage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoyageRepo extends JpaRepository <Voyage, Long> {

   // VoyageRepo findBynumVoyage(String numVoyage);
}

package groupe3.compagnieAerienne.repository;

import groupe3.compagnieAerienne.model.Escale;
import groupe3.compagnieAerienne.model.Passager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassagerRepo extends JpaRepository <Passager, Long> {

  //  Passager findByNumEscale(Long NumEscale);
}

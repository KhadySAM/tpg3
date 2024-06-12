package groupe3.compagnieAerienne.repository;

import groupe3.compagnieAerienne.model.Avion;
import groupe3.compagnieAerienne.model.Equipage;
import groupe3.compagnieAerienne.model.Escale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EscaleRepo extends JpaRepository <Escale, Long> {

    Escale findByNumEscale(Long NumEscale);
}

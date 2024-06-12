package groupe3.compagnieAerienne.repository;

import groupe3.compagnieAerienne.model.Escale;
import groupe3.compagnieAerienne.model.Membre;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembreRepo extends JpaRepository <Membre, Long> {

   // Membre findByNumEscale(Long NumEscale);
}

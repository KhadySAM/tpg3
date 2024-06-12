package groupe3.compagnieAerienne.repository;

import groupe3.compagnieAerienne.model.Equipage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipageRepo extends JpaRepository <Equipage, Long> {
    Equipage findByNumEquipage(Long numEquipage);
}

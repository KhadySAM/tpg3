package groupe3.compagnieAerienne.service;

import groupe3.compagnieAerienne.model.Equipage;

import java.util.List;

public interface EquiageService {

    Object ajouterEquipage(Equipage equipage);

    Object supprimerEquipage(Long id);

    Object ModifierEquipage(Equipage equipage, Long id);

    Object afficherUnEquipage(Long id);

    List<Equipage> afficherTousLesEquipage();

}

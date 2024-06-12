package groupe3.compagnieAerienne.service;

import groupe3.compagnieAerienne.model.Avion;

import java.util.List;

public interface AvionService {

    Object ajouterAvion(Avion avion);

    Object supprimerAvion(Long id);

    Object ModifierAvion(Avion avion, Long id);

    Object afficherUnAvion(Long id);

    List<Avion> afficherTousLesAvion();
}

package groupe3.compagnieAerienne.service;

import groupe3.compagnieAerienne.model.Voyage;

import java.util.List;

public interface VoyageService {

    Object ajouterVoyage(Voyage voyage);

    Object supprimerVoyage(Long id);

    Object ModifierVoyage(Voyage voyage, Long id);

    Object afficherUnVoyage(Long id);

    List<Voyage> afficherTousLesVoyage();

}

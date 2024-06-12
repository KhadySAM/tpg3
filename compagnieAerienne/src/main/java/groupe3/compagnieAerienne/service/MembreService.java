package groupe3.compagnieAerienne.service;

import groupe3.compagnieAerienne.model.Membre;

import java.util.List;

public interface MembreService {

    Object ajouterMembre(Membre membre);

    Object supprimerMembre(Long id);

    Object ModifierMembre(Membre membre, Long id);

    Object afficherUnMembre(Long id);

    List<Membre> afficherTousLesMembre();

}

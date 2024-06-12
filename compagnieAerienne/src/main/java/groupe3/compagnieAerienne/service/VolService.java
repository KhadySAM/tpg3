package groupe3.compagnieAerienne.service;

import groupe3.compagnieAerienne.model.Vol;

import java.util.List;

public interface VolService {

    Object ajouterVol(Vol vol);

    Object supprimerVol(Long id);

    Object ModifierVol(Vol vol, Long id);

    Object afficherUnVol(Long id);

    List<Vol> afficherTousLesVol();

}

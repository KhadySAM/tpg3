package groupe3.compagnieAerienne.service;

import groupe3.compagnieAerienne.model.Equipage;
import groupe3.compagnieAerienne.model.Escale;

import java.util.List;

public interface EscaleService {

    Object ajouterEscale(Escale escale);

    Object supprimerEscale(Long id);

    Object ModifierEscale(Escale escale, Long id);

    Object afficherUnEscale(Long id);

    List<Escale> afficherTousLesEscale();
}

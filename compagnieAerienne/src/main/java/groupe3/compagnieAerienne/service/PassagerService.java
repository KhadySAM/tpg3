package groupe3.compagnieAerienne.service;

import groupe3.compagnieAerienne.model.Passager;

import java.util.List;

public interface PassagerService {

    Object ajouterPassager(Passager passager);

    Object supprimerPassager(Long id);

    Object ModifierPassager(Passager passager, Long id);

    Object afficherUnPassager(Long id);

    List<Passager> afficherTousLesPassager();

}

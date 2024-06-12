package groupe3.compagnieAerienne.service.ServiceImplemente;

import groupe3.compagnieAerienne.model.Membre;
import groupe3.compagnieAerienne.repository.MembreRepo;
import groupe3.compagnieAerienne.service.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembreServiceImpl implements MembreService {

    @Autowired
    MembreRepo membreRepo;

    @Override
    public Object ajouterMembre(Membre membre) {

        membreRepo.findById(membre.getId());
        return "membre ajouter succès";
    }

    @Override
    public Object supprimerMembre(Long id) {

        Optional<Membre> membre = membreRepo.findById(id);
        if (membre.isEmpty()) {
            return "Cet membre n'existe pas !";
        }
        else {
            membreRepo.delete(membre.get());
            return "membre supprimé avec succès";
        }
    }

    @Override
    public Object ModifierMembre(Membre membre, Long id) {

        Optional<Membre> membreExiste = this.membreRepo.findById(id);
        if (membreExiste.isEmpty()) {
            return "Membre non trouvé !";

        }
        else {
            Membre membreMod = membreRepo.findById(id).get();
            membreMod.setNom(membre.getNom());
            membreMod.setPrenom(membre.getPrenom());
            membreMod.setDateNaissance(membre.getDateNaissance());
            return "membre modifier avec succès";
        }
    }

    @Override
    public Object afficherUnMembre(Long id) {

        Optional<Membre> membre = membreRepo.findById(id);

        if (membre.isEmpty()) {

            return  "Cet membre n'est pas trouvée !";
        }
        else {
            return membreRepo.findById(id).get();
        }
    }

    @Override
    public List<Membre> afficherTousLesMembre() {

        return membreRepo.findAll();
    }
}

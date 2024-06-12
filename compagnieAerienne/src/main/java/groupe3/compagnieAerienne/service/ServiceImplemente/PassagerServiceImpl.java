package groupe3.compagnieAerienne.service.ServiceImplemente;

import groupe3.compagnieAerienne.model.Passager;
import groupe3.compagnieAerienne.repository.PassagerRepo;
import groupe3.compagnieAerienne.service.PassagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassagerServiceImpl implements PassagerService {

    @Autowired
    private PassagerRepo passagerRepo;

    @Override
    public Object ajouterPassager(Passager passager) {
        passagerRepo.findById(passager.getId());
        return "passager ajouter succès";
    }

    @Override
    public Object supprimerPassager(Long id) {

        Optional<Passager> passager = passagerRepo.findById(id);
        if (passager.isEmpty()) {
            return "Cet passager n'existe pas !";
        }
        else {
            passagerRepo.delete(passager.get());
            return "Passager supprimé avec succès";
        }
    }

    @Override
    public Object ModifierPassager(Passager passager, Long id) {

        Optional<Passager> passagerExiste = this.passagerRepo.findById(id);
        if (passagerExiste.isEmpty()) {
            return "Passager non trouvé !";

        }
        else {
            Passager passagerMod = passagerRepo.findById(id).get();
            passagerMod.setNom(passager.getNom());
            passagerMod.setPrenom(passager.getPrenom());
            passagerMod.setDateNaissance(passager.getDateNaissance());
            return "passager modifier avec succès";
        }
    }

    @Override
    public Object afficherUnPassager(Long id) {

        Optional<Passager> passager = passagerRepo.findById(id);

        if (passager.isEmpty()) {

            return  "Cet passager n'est pas trouvée !";
        }
        else {
            return passagerRepo.findById(id).get();
        }
    }

    @Override
    public List<Passager> afficherTousLesPassager() {
        return passagerRepo.findAll();
    }
}

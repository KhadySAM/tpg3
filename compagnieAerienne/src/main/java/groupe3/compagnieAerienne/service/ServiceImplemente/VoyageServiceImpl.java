package groupe3.compagnieAerienne.service.ServiceImplemente;

import groupe3.compagnieAerienne.model.Voyage;
import groupe3.compagnieAerienne.repository.VoyageRepo;
import groupe3.compagnieAerienne.service.VoyageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoyageServiceImpl implements VoyageService {

    @Autowired
    private VoyageRepo voyageRepo;

    @Override
    public Object ajouterVoyage(Voyage voyage) {
        voyageRepo.findById(voyage.getId());
        return "voyage ajouter succès";
    }

    @Override
    public Object supprimerVoyage(Long id) {

        Optional<Voyage> voyage = voyageRepo.findById(id);
        if (voyage.isEmpty()) {
            return "Cet voyage n'existe pas !";
        }
        else {
            voyageRepo.delete(voyage.get());
            return "Avion supprimé avec succès";
        }
    }

    @Override
    public Object ModifierVoyage(Voyage voyage, Long id) {

        Optional<Voyage> voyageExiste = this.voyageRepo.findById(id);
        if (voyageExiste.isEmpty()) {
            return "Voyage non trouvé !";

        }
        else {
            Voyage voyageMod = voyageRepo.findById(id).get();
            voyageMod.setNumVoyage(voyage.getNumVoyage());
            voyageMod.setDateVoyage(voyage.getDateVoyage());
            return "Pays modifier avec succès";
        }
    }

    @Override
    public Object afficherUnVoyage(Long id) {

        Optional<Voyage> voyage = voyageRepo.findById(id);

        if (voyage.isEmpty()) {

            return  "Cet voyage n'est pas trouvée !";
        }
        else {
            return voyageRepo.findById(id).get();
        }
    }

    @Override
    public List<Voyage> afficherTousLesVoyage() {
        return voyageRepo.findAll();
    }
}

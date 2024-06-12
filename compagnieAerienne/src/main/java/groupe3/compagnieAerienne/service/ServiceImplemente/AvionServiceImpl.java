package groupe3.compagnieAerienne.service.ServiceImplemente;

import groupe3.compagnieAerienne.model.Avion;
import groupe3.compagnieAerienne.repository.AvionRepo;
import groupe3.compagnieAerienne.service.AvionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvionServiceImpl implements AvionService {

    @Autowired
    private AvionRepo avionRepo;

    @Override
    public Object ajouterAvion(Avion avion) {
        if(avionRepo.findByMatricule(avion.getMatricule()) == null) {

            avionRepo.save(avion);

            return "avion ajouter succès";
        }else {
            return "cet avion existe déjà";
        }
    }

    @Override
    public Object supprimerAvion(Long id) {
        Optional<Avion> avion = avionRepo.findById(id);
        if (!avion.isPresent()) {
            return "Cet avion n'existe pas !";
        }
        else {

            avionRepo.delete(avion.get());
            return "Avion supprimé avec succès";
        }
    }

    @Override
    public Object ModifierAvion(Avion avion, Long id) {
        Optional<Avion> avionExiste = this.avionRepo.findById(id);
        if (avionExiste.isEmpty()) {
            return "Avion non trouvé !";

        }
        else {
            Avion avionMod = avionRepo.findById(id).get();
            avionMod.setType(avion.getType());
            avionMod.setMarque(avion.getMarque());
            avionMod.setNbrePlaces(avion.getNbrePlaces());

            return "Avion modifier avec succès";
        }
    }

    @Override
    public Object afficherUnAvion(Long id) {
        Optional<Avion> avion = avionRepo.findById(id);

        if (avion.isEmpty()) {

            return  "Cet avion n'est pas trouvée !";
        }
        else {
            return avionRepo.findById(id).get();
        }
    }

    @Override
    public List<Avion> afficherTousLesAvion() {
        return avionRepo.findAll();
    }
}

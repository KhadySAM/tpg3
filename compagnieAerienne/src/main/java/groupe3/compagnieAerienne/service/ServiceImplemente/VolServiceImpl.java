package groupe3.compagnieAerienne.service.ServiceImplemente;

import groupe3.compagnieAerienne.model.Vol;
import groupe3.compagnieAerienne.repository.VolRepo;
import groupe3.compagnieAerienne.service.VolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VolServiceImpl implements VolService {

    @Autowired
    private VolRepo volRepo;

    @Override
    public Object ajouterVol(Vol vol) {
        volRepo.findById(vol.getId());
        return "vol ajouter succès";
    }

    @Override
    public Object supprimerVol(Long id) {

        Optional<Vol> vol = volRepo.findById(id);
        if (vol.isEmpty()) {
            return "Cet vol n'existe pas !";
        }
        else {
            volRepo.delete(vol.get());
            return "Vol supprimé avec succès";
        }
    }

    @Override
    public Object ModifierVol(Vol vol, Long id) {

        Optional<Vol> volExiste = this.volRepo.findById(id);
        if (volExiste.isEmpty()) {
            return "Vol non trouvé !";

        }
        else {
            Vol volMod = volRepo.findById(id).get();
            volMod.setVilleArrive(vol.getVilleArrive());
            volMod.setVilleDepart(vol.getVilleDepart());
            return "vol modifier avec succès";
        }
    }

    @Override
    public Object afficherUnVol(Long id) {

        Optional<Vol> vol = volRepo.findById(id);

        if (vol.isEmpty()) {

            return  "Cet vol n'est pas trouvée !";
        }
        else {
            return volRepo.findById(id).get();
        }
    }

    @Override
    public List<Vol> afficherTousLesVol() {

        return volRepo.findAll();
    }
}

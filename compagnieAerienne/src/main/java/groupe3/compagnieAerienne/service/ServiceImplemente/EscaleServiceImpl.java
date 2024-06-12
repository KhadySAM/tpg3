package groupe3.compagnieAerienne.service.ServiceImplemente;

import groupe3.compagnieAerienne.model.Escale;
import groupe3.compagnieAerienne.repository.EscaleRepo;
import groupe3.compagnieAerienne.service.EscaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EscaleServiceImpl implements EscaleService {

    @Autowired
    EscaleRepo escaleRepo;

    @Override
    public Object ajouterEscale(Escale escale) {
        if(escaleRepo.findByNumEscale(escale.getNumEscale()) == null) {

            escaleRepo.save(escale);

            return "escale ajouter succès";
        }else {
            return "cet escale existe déjà";
        }
    }

    @Override
    public Object supprimerEscale(Long id) {
        Optional<Escale> escale = escaleRepo.findById(id);
        if (!escale.isPresent()) {
            return "Cet escale n'existe pas !";
        }
        else {

            escaleRepo.delete(escale.get());
            return "Escale supprimé avec succès";
        }
    }

    @Override
    public Object ModifierEscale(Escale escale, Long id) {
        return null;
    }

    @Override
    public Object afficherUnEscale(Long id) {
        return null;
    }

    @Override
    public List<Escale> afficherTousLesEscale() {
        return null;
    }
}

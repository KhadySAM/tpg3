package groupe3.compagnieAerienne.service.ServiceImplemente;

import groupe3.compagnieAerienne.model.Equipage;
import groupe3.compagnieAerienne.repository.EquipageRepo;
import groupe3.compagnieAerienne.service.EquiageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipageServiceImpl implements EquiageService{
    @Autowired
    EquipageRepo equipageRepo;
    @Override
    public Object ajouterEquipage(Equipage equipage) {
        if(equipageRepo.findByNumEquipage(equipage.getNumEquipage()) == null) {

            equipageRepo.save(equipage);
            return "equipage ajouter succès";
        }else {
            return "cet equipage existe déjà";
        }
    }

    @Override
    public Object supprimerEquipage(Long id) {
        Optional<Equipage> equipage = equipageRepo.findById(id);
        if (!equipage.isPresent()) {
            return "Cet equipage n'existe pas !";
        }
        else {

            equipageRepo.delete(equipage.get());
            return "Equipage supprimé avec succès";
        }
    }

    @Override
    public Object ModifierEquipage(Equipage equipage, Long id) {
        return null;
    }

    @Override
    public Object afficherUnEquipage(Long id) {
        return null;
    }

    @Override
    public List<Equipage> afficherTousLesEquipage() {
        return null;
    }
}

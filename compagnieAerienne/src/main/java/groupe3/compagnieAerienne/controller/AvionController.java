package groupe3.compagnieAerienne.controller;

import groupe3.compagnieAerienne.model.Avion;
import groupe3.compagnieAerienne.service.AvionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/groupe3")
public class AvionController {

    @Autowired
    AvionService avionService;

    @PostMapping("/ajouteravion")
    public Object  addAvion(@Param("matricule") String matricule,
                           @Param("marque") String marque,
                           @Param("type") String type,
                           @Param("nbrePlaces") Long nbrePlaces) throws IOException {
        Avion avion = new Avion();
        avion.setMatricule(matricule);
        avion.setMarque(marque);
        avion.setType(type);
        avion.setNbrePlaces(nbrePlaces);

        return  avionService.ajouterAvion(avion);
    }



    // Afficher tous les avions enregistrer
    @GetMapping("/getallavion")
    public List<Avion> getAllAvion() {

        return avionService.afficherTousLesAvion();
    }

    // Afficher un avions par id
    @GetMapping("/getoneavion/{id}")
    public Object afficheravionsParId(@PathVariable Long id) {

        return avionService.afficherUnAvion(id);
    }

    // Modifier un avions par id
    @PutMapping("/modifieravion/{id}")
    public  Object updateAvions(@RequestBody Avion avion, @PathVariable Long id) {

        return avionService.ModifierAvion(avion, id);
    }

    // Supprimer un avion par id
    @DeleteMapping("/deleteavion/{id}")
    public Object deleteAvion(@PathVariable Long id) {

        return  avionService.supprimerAvion(id);
    }
}

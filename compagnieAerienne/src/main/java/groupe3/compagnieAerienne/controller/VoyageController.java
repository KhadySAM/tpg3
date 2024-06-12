package groupe3.compagnieAerienne.controller;

import groupe3.compagnieAerienne.model.Voyage;
import groupe3.compagnieAerienne.service.VoyageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/groupe3")
public class VoyageController {

    @Autowired
    VoyageService voyageService;

    @PostMapping("/ajoutervoyage")
    public Object  add(@Param("numVoyage") Long numVoyage,
                       @Param("dateVoyage") Date dateVoyage) throws IOException {
        Voyage voyage = new Voyage();
        voyage.setNumVoyage(numVoyage);
        voyage.setDateVoyage(dateVoyage);

        return  voyageService.ajouterVoyage(voyage);
    }

    // Afficher tous les voyage enregistrer
    @GetMapping("/getallcritere")
    public List<Voyage> getAllVoyage() {

        return voyageService.afficherTousLesVoyage();
    }

    // Afficher un voyage par id
    @GetMapping("/getonetvoyage/{id}")
    public Object afficherVoyageParId(@PathVariable Long id) {

        return voyageService.afficherUnVoyage(id);
    }

    // Modifier un voyage par id
    @PutMapping("/modifiervoyage/{id}")
    public  Object updateCriteres(@RequestBody Voyage voyage, @PathVariable Long id) {

        return voyageService.ModifierVoyage(voyage, id);
    }

    // Supprimer un voyage par id
    @DeleteMapping("/deletevoyage/{id}")
    public Object deleteVoyage(@PathVariable Long id) {

        return  voyageService.supprimerVoyage(id);
    }
}
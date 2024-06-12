package groupe3.compagnieAerienne.controller;

import groupe3.compagnieAerienne.model.Equipage;
import groupe3.compagnieAerienne.service.EquiageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/groupe3")
public class EquipageController {

    @Autowired
    EquiageService equiageService;

    @PostMapping("/ajouterequipage")
    public Object  addEquipage(@Param("numEquipage") Long numEquipage,
                                @Param("numCommandant") Long numCommandant,
                                @Param("numCopilote") Long numCopilote,
                                @Param("numMecanicien") Long numMecanicien,
                                @Param("numHotesse") Long numHotesse) throws IOException {
        Equipage equipage = new Equipage();
        equipage.setNumEquipage(numEquipage);
        equipage.setNumCommandant(numCommandant);
        equipage.setNumCopilote(numCopilote);
        equipage.setNumMecanicien(numMecanicien);
        equipage.setNumHotesse(numHotesse);

        return  equiageService.ajouterEquipage(equipage);
    }



    // Afficher tous les equipage enregistrer
    @GetMapping("/getallequipage")
    public List<Equipage> getAllEquipage() {

        return equiageService.afficherTousLesEquipage();
    }

    // Afficher un equipage par id
    @GetMapping("/getoneequipage/{id}")
    public Object afficherequipageParId(@PathVariable Long id) {

        return equiageService.afficherUnEquipage(id);
    }

    // Modifier un equipage par id
    @PutMapping("/modifierequipage/{id}")
    public  Object updateEquipage(@RequestBody Equipage equipage, @PathVariable Long id) {

        return equiageService.ModifierEquipage(equipage, id);
    }

    // Supprimer un avion par id
    @DeleteMapping("/deleteequipage/{id}")
    public Object deleteEquipage(@PathVariable Long id) {

        return  equiageService.supprimerEquipage(id);
    }
}

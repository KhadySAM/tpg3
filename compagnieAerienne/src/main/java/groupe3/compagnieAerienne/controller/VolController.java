package groupe3.compagnieAerienne.controller;

import groupe3.compagnieAerienne.model.Passager;
import groupe3.compagnieAerienne.model.Vol;
import groupe3.compagnieAerienne.service.PassagerService;
import groupe3.compagnieAerienne.service.VolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;;
import java.util.List;
@RestController
@RequestMapping("/groupe3")
public class VolController {

    @Autowired
    VolService volService;

    @PostMapping("/ajoutervol")
    public Object  addVol(@Param("villeDepart") String villeDepart,
                          @Param("villeArrive") String villeArrive) throws IOException {
        Vol vol = new Vol();
        vol.setVilleDepart(villeDepart);
        vol.setVilleArrive(villeArrive);

        return  volService.ajouterVol(vol);
    }



    // Afficher tous les vol enregistrer
    @GetMapping("/getallvol")
    public List<Vol> getAllVol() {

        return volService.afficherTousLesVol();
    }

    // Afficher un vol par id
    @GetMapping("/getonevol/{id}")
    public Object afficherVolParId(@PathVariable Long id) {

        return volService.afficherUnVol(id);
    }

    // Modifier un vol par id
    @PutMapping("/modifiervol/{id}")
    public  Object updateVol(@RequestBody Vol vol, @PathVariable Long id) {

        return volService.ModifierVol(vol, id);
    }

    // Supprimer un vol par id
    @DeleteMapping("/deletevol/{id}")
    public Object deleteVol(@PathVariable Long id) {

        return  volService.supprimerVol(id);
    }
}

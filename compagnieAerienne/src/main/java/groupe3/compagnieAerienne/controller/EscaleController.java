package groupe3.compagnieAerienne.controller;

import groupe3.compagnieAerienne.model.Equipage;
import groupe3.compagnieAerienne.model.Escale;
import groupe3.compagnieAerienne.service.EquiageService;
import groupe3.compagnieAerienne.service.EscaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/groupe3")
public class EscaleController {
    @Autowired
    EscaleService escaleService;

    @PostMapping("/ajoutescale")
    public Object  addEscale(  @Param("numEscale") Long numEscale,
                               @Param("aeredrome") String aeredrome) throws IOException {
        Escale escale = new Escale();
        escale.setNumEscale(numEscale);
        escale.setAeredrome(aeredrome);
        return  escaleService.ajouterEscale(escale);
    }

    // Afficher tous les escale enregistrer
    @GetMapping("/getallescale")
    public List<Escale> getAllEscale() {
        return escaleService.afficherTousLesEscale();
    }

    // Afficher un escale par id
    @GetMapping("/getoneescale/{id}")
    public Object afficherescaleParId(@PathVariable Long id) {
        return escaleService.afficherUnEscale(id);
    }

    // Modifier un equipage par id
    @PutMapping("/modifierescale/{id}")
    public  Object updateEscale(@RequestBody Escale escale, @PathVariable Long id) {
        return escaleService.ModifierEscale(escale, id);
    }

    // Supprimer un escale par id
    @DeleteMapping("/deleteescale/{id}")
    public Object deleteEscale(@PathVariable Long id) {
        return  escaleService.supprimerEscale(id);
    }
}

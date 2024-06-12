package groupe3.compagnieAerienne.controller;

import groupe3.compagnieAerienne.model.Passager;
import groupe3.compagnieAerienne.service.PassagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/groupe3")
public class PassagerController {

    @Autowired
    PassagerService passagerService;

    @PostMapping("/ajouterpassager")
    public Object  addPassager(  @Param("nom") String nom,
                                 @Param("prenom") String prenom,
                                 @Param("dateNaissance") Date dateNaissance) throws IOException {
        Passager passager = new Passager();
        passager.setNom(nom);
        passager.setPrenom(prenom);
        passager.setDateNaissance(dateNaissance);
        return  passagerService.ajouterPassager(passager);
    }

    // Afficher tous les passager enregistrer
    @GetMapping("/getallpassager")
    public List<Passager> getAllPassager() {
        return passagerService.afficherTousLesPassager();

    }

    // Afficher un passager par id
    // @GetMapping("/getonepassager/{id}")
    public Object afficherPassagerParId(@PathVariable Long id) {
        return passagerService.afficherUnPassager(id);
    }

    // Modifier un passager par id
    @PutMapping("/modifierpassager/{id}")



    public  Object updateMembre(@RequestBody Passager passager, @PathVariable Long id) {
        return passagerService.ModifierPassager(passager, id);
    }

    // Supprimer un passager par id
    @DeleteMapping("/deletepassager/{id}")
    public Object deletePassager(@PathVariable Long id) {
        return  passagerService.supprimerPassager(id);
    }
}
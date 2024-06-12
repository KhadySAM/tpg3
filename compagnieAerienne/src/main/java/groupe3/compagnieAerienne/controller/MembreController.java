package groupe3.compagnieAerienne.controller;

import groupe3.compagnieAerienne.model.Membre;
import groupe3.compagnieAerienne.service.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;
@RestController
@RequestMapping("/groupe3")
public class MembreController {

    @Autowired
    MembreService membreService;

    @PostMapping("/ajoutermembre")
    public Object  addMembre(  @Param("nom") String nom,
                               @Param("prenom") String prenom,
                               @Param("dateNaissance") Date dateNaissance,
                               @Param("fonction") String fonction) throws IOException {
        Membre membre = new Membre();
        membre.setNom(nom);
        membre.setPrenom(prenom);
        membre.setDateNaissance(dateNaissance);
        membre.setFonction(fonction);

        return  membreService.ajouterMembre(membre);
    }



    // Afficher tous les membres enregistrer
    @GetMapping("/getallmembre")
    public List<Membre> getAllMembre() {

        return membreService.afficherTousLesMembre();
    }

    // Afficher un membre par id
    @GetMapping("/getonemembre/{id}")
    public Object affichermembreParId(@PathVariable Long id) {

        return membreService.afficherUnMembre(id);
    }

    // Modifier un membre par id
    @PutMapping("/modifiermembre/{id}")
    public  Object updateMembre(@RequestBody Membre membre, @PathVariable Long id) {

        return membreService.ModifierMembre(membre, id);
    }

    // Supprimer un escale par id
    @DeleteMapping("/deletemembre/{id}")
    public Object deleteMembre(@PathVariable Long id) {

        return  membreService.supprimerMembre(id);
    }
}

package tn.esprit.spring.seance1.Controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.seance1.Entities.Foyer;
import tn.esprit.spring.seance1.Entities.Universite;
import tn.esprit.spring.seance1.ServicesIMP.UniversiteServicesIMP;
import tn.esprit.spring.seance1.ServicesInterfaces.UniversiteInterface;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/UniversiteC")
public class UniversiteController {

    @GetMapping("/retrieveAllUniversities")
    public List<Universite> retrieveAllUniversities()
    {
        return universiteInterface.retrieveAllUniversities();
    }

    @PostMapping("/addUniversity")
    public Universite addUniversity(@RequestBody Universite u)
    {
        return universiteInterface.addUniversity(u);
    }

    @PutMapping("/updateUniversity")
    public Universite updateUniversity(@RequestBody Universite u)
    {
        return universiteInterface.updateUniversity(u);
    }


    @GetMapping("/retrieveUniversity")
    public Universite retrieveUniversity(@PathVariable long idUniversity) {
        return universiteInterface.retrieveUniversity(idUniversity);
    }

    @PutMapping("/affecterFoyerAUniversite/{idFoyer}/{nomUniversite}")
    public Universite affecterFoyerAUniversite(@PathVariable long idFoyer, @PathVariable String nomUniversite)
    {
        return universiteInterface.affecterFoyerAUniversite(idFoyer, nomUniversite);
    }

    @PutMapping("/desaffecterFoyerAUniversite/{idUniversite}")
    public Universite desaffecterFoyerAUniversite(@PathVariable long idUniversite) {
        return universiteInterface.desaffecterFoyerAUniversite(idUniversite);
    }

    UniversiteInterface universiteInterface ;
}

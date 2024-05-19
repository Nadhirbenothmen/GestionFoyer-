package tn.esprit.spring.seance1.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.seance1.Entities.Bloc;
import tn.esprit.spring.seance1.Entities.Foyer;
import tn.esprit.spring.seance1.ServicesIMP.FoyerServicesIMP;
import tn.esprit.spring.seance1.ServicesInterfaces.FoyerInterface;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/FoyerC") // Optionnelle
public class FoyerController {

    @GetMapping("/retrieveAllFoyers")
    public List<Foyer> retrieveAllFoyers() { return foyerInterface.retrieveAllFoyers(); }

    @PostMapping("/addFoyer")
    public Foyer addFoyer(@RequestBody Foyer f) { return foyerInterface.addFoyer(f); }

    @PutMapping("/updateFoyer")
    public Foyer updateFoyer(@RequestBody Foyer f) { return foyerInterface.updateFoyer(f); }

    @GetMapping("/findfoyerbyid/{idFoyer}")
    public Foyer retrieveFoyer(@PathVariable long idFoyer) { return foyerInterface.retrieveFoyer(idFoyer); }

    @DeleteMapping("/delete/{idFoyer}")
    public void removeFoyer(@PathVariable long idFoyer) { foyerInterface.removeFoyer(idFoyer); }


    FoyerServicesIMP foyerService;

    @PutMapping("/getFoyerByUniversiteId/{idUniversite}")
    public Foyer getFoyerByUniversiteId(@PathVariable Long idUniversite) {
        return foyerInterface.getFoyerByUniversiteId(idUniversite);
    }

    FoyerInterface foyerInterface ;
}

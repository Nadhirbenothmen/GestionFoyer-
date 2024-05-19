package tn.esprit.spring.seance1.Controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.seance1.Entities.Bloc;
import tn.esprit.spring.seance1.Entities.Chambre;
import tn.esprit.spring.seance1.Entities.Foyer;
import tn.esprit.spring.seance1.ServicesIMP.BlocServicesIMP;
import tn.esprit.spring.seance1.ServicesInterfaces.BlocInterface;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("BlocC")
public class BlocController {

    @GetMapping("/retrieveBlocs")
    public List<Bloc> retrieveBlocs() { return blocInterface.retrieveBlocs(); }

    @PutMapping("/updateBloc")
    public Bloc updateBloc(@RequestBody Bloc bloc) { return blocInterface.updateBloc(bloc); }

    @PostMapping("/addBloc")
    public Bloc addBloc(@RequestBody Bloc bloc) { return blocInterface.addBloc(bloc); }

    @GetMapping("/findblocbyid/{idBloc}")
    public Bloc retrieveBloc(@PathVariable long idBloc) { return blocInterface.retrieveBloc(idBloc); }

    @DeleteMapping("/delete/{idBloc}")
    public void removeBloc(@PathVariable long idBloc) { blocInterface.removeBloc(idBloc); }

    @PutMapping("/ajouterFoyerEtAffecterAUniversite/{idUniversite}")
    public Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer,@PathVariable long idUniversite) {
        return blocInterface.ajouterFoyerEtAffecterAUniversite(foyer, idUniversite);
    }

    @PutMapping("/getBlocsByFoyerId/{idfoyer}")
    public List<Bloc> getBlocsByFoyerId(@PathVariable Long idfoyer) {
        return blocInterface.getBlocsByFoyerId(idfoyer);
    }

    @PutMapping("/getBlocByChambreId/{idChambre}")
    public Bloc getBlocByChambreId(@PathVariable Long idChambre) {
        return blocInterface.getBlocByChambreId(idChambre);
    }

@PutMapping("/getBlocsAndUniversiteAdresseByFoyerName/{nomFoyer}")
    public Set<Bloc> getBlocsAndUniversiteAdresseByFoyerName(@PathVariable String nomFoyer) {
        return blocInterface.getBlocsAndUniversiteAdresseByFoyerName(nomFoyer);
    }

    BlocInterface blocInterface ;

}

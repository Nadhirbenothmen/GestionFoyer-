package tn.esprit.spring.seance1.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.seance1.Entities.Bloc;
import tn.esprit.spring.seance1.Entities.Chambre;
import tn.esprit.spring.seance1.Entities.Foyer;
import tn.esprit.spring.seance1.Entities.TypeChambre;
import tn.esprit.spring.seance1.ServicesIMP.ChambreServicesIMP;
import tn.esprit.spring.seance1.ServicesInterfaces.ChambreInterface;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/ChambreC")
public class ChambreConstroller {


    @GetMapping("/retrieveAllChambres")
    public List<Chambre> retrieveAllChambres() { return chambreInterface.retrieveAllChambres(); }

    @PostMapping("/addChambre")
    public Chambre addChambre(@RequestBody Chambre c) { return chambreInterface.addChambre(c); }

    @PutMapping("/updateChambre")
    public Chambre updateChambre(@RequestBody Chambre c) { return chambreInterface.updateChambre(c); }

    @GetMapping("/findchambrebyid/{idChambre}")
    public Chambre retrieveChambre(@PathVariable long idChambre) { return chambreInterface.retrieveChambre(idChambre); }

    @PutMapping("/affecterChambresABloc/{idBloc}")
    public Bloc affecterChambresABloc(@RequestBody List<Long> numChambre, @PathVariable long idBloc) {
        return  chambreInterface.affecterChambresABloc(numChambre,idBloc);
    }
    @PutMapping("/getChambresParNomUniversite/{nomUniversite}")
    public List<Chambre> getChambresParNomUniversite(@PathVariable String nomUniversite) {
        return chambreInterface.getChambresParNomUniversite(nomUniversite);
    }
    @PutMapping("/getChambresParBlocEtType/{idBloc}/{typeC}")
    public List<Chambre> getChambresParBlocEtType(@PathVariable long idBloc,@PathVariable TypeChambre typeC) {
        return chambreInterface.getChambresParBlocEtType(idBloc, typeC);
    }
    @PutMapping("/getChambresByBlocId/{idBloc}")
    public List<Chambre> getChambresByBlocId(@PathVariable Long idBloc) {
        return chambreInterface.getChambresByBlocId(idBloc);
    }
    @PutMapping("/getDoubleChambresWithValidReservations")
    public List<Chambre> getDoubleChambresWithValidReservations() {
        return chambreInterface.getDoubleChambresWithValidReservations();
    }
    @PutMapping("/getChambresByFoyerWithCapacityGreaterThan/{capacite}")
    public List<Chambre> getChambresByFoyerWithCapacityGreaterThan(@RequestBody Foyer foyer,@PathVariable Long capacite)
    {
        return chambreInterface.getChambresByFoyerWithCapacityGreaterThan(foyer, capacite);
    }

    @PutMapping("/getChambresNonReserveParNomUniversiteEtTypeChambre/{nomUniversite}/{type}")
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(@PathVariable String nomUniversite,@PathVariable TypeChambre type)
    {
        return chambreInterface.getChambresNonReserveParNomUniversiteEtTypeChambre(nomUniversite, type);
    }

    @PutMapping("/afficherChambresNonReservees")
    public List<Chambre> afficherChambresNonReservees() {
        return chambreInterface.afficherChambresNonReservees();
    }

    ChambreInterface chambreInterface ;
}

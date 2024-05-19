package tn.esprit.spring.seance1.Controllers;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.seance1.Entities.Etudiant;
import tn.esprit.spring.seance1.ServicesIMP.BlocServicesIMP;
import tn.esprit.spring.seance1.ServicesInterfaces.EtudiantInterface;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("EtudiantC")
public class EtudiantController {


    @GetMapping("/retrieveAllEtudiants")
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantInterface.retrieveAllEtudiants();
    }

    @PostMapping("/addEtudiants")
    public List<Etudiant> addEtudiants(@RequestBody List<Etudiant> etudiants) {
        return etudiantInterface.addEtudiants(etudiants);
    }

    @PutMapping("/updateEtudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant e) {
        return etudiantInterface.updateEtudiant(e);
    }

    @GetMapping("/findetudiantbyid/{idEtudiant}")
    public Etudiant retrieveEtudiant(@PathVariable long idEtudiant) {
        return etudiantInterface.retrieveEtudiant(idEtudiant);
    }

    @DeleteMapping("/delete/{idEtudiant}")
    public void removeEtudiant(@PathVariable long idEtudiant) {
        etudiantInterface.removeEtudiant(idEtudiant);
    }

    @PutMapping("/getEtudiantsByCurrentAcademicYear")
    public List<Etudiant> getEtudiantsByCurrentAcademicYear() {
        return etudiantInterface.getEtudiantsByCurrentAcademicYear();
    }

    EtudiantInterface etudiantInterface ;
}

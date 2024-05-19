package tn.esprit.spring.seance1.ServicesIMP;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.seance1.Entities.Etudiant;
import tn.esprit.spring.seance1.Repositories.EtudiantRepository;
import tn.esprit.spring.seance1.ServicesInterfaces.EtudiantInterface;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Service
public class EtudiantServicesIMP implements EtudiantInterface {

    //@Autowired
    EtudiantRepository etudiantRepository ;
    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> etudiants) {
        return etudiantRepository.saveAll(etudiants); // utilisé avec la liste
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {

        return etudiantRepository.save(e); // save pour faire l'update
    }

    @Override
    public Etudiant retrieveEtudiant(long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
        // pour éviter l'erreur
    }

    @Override
    public void removeEtudiant(long idEtudiant) { etudiantRepository.deleteById(idEtudiant); }

    @Override
    public List<Etudiant> getEtudiantsByCurrentAcademicYear()
    {
        // LocalDate currentYear = LocalDate.now().withDayOfYear(1);
        LocalDate currentYear = LocalDate.now();
        return etudiantRepository.findByReservations_AnneeUniversite(currentYear);
    }

    /*
    public List<Etudiant> getEtudiantsOfCurrentAcademicYear(String anneeUniversitaire) {
        return etudiantRepository.findEtudiantsByAnneeUniversitaire(anneeUniversitaire);
    }   */

}


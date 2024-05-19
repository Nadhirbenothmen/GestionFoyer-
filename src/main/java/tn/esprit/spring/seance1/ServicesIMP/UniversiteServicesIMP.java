package tn.esprit.spring.seance1.ServicesIMP;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.seance1.Entities.Foyer;
import tn.esprit.spring.seance1.Entities.Universite;
import tn.esprit.spring.seance1.Repositories.FoyerRepository;
import tn.esprit.spring.seance1.Repositories.UniversiteRepository;
import tn.esprit.spring.seance1.ServicesInterfaces.UniversiteInterface;
import java.util.List;

@AllArgsConstructor
@Service

public class UniversiteServicesIMP implements UniversiteInterface {

    UniversiteRepository universiteRepository ;
    FoyerRepository foyerRepository ;



    @Override
    public List<Universite> retrieveAllUniversities() { return universiteRepository.findAll(); }

    @Override
    public Universite addUniversity(Universite u) {
        if (u != null) {
            return universiteRepository.save(u); // Sauvegarde le Bloc dans la base de données
        } else {
            // Gérez le cas où le Bloc est nul
            return null;
        }    }

    @Override
    public Universite updateUniversity(Universite u) { return universiteRepository.save(u); }

    @Override
    public Universite retrieveUniversity(long idUniversity) {
        return universiteRepository.findById(idUniversity).orElse(null);
    }

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        // Trouver le foyer
        Foyer foyer = foyerRepository.findById(idFoyer).orElse(null);
        // Trouver l'université
        Universite universite = universiteRepository.findBynomUniversiteLike(nomUniversite);
        // Affecter le foyer à l'université
        universite.setFoyer(foyer);
        // Sauvegarder l'université
        return universiteRepository.save(universite);
    }

    @Override
    public Universite desaffecterFoyerAUniversite (long idUniversite) {
        // Trouver l'université
        Universite u = universiteRepository.findById(idUniversite).orElse(null);
        // Désaffecter le foyer
        u.setFoyer(null);
        // Sauvegarder l'université
        universiteRepository.save(u);
        return u;
    }

}

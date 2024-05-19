package tn.esprit.spring.seance1.ServicesIMP;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.seance1.Entities.Bloc;
import tn.esprit.spring.seance1.Entities.Chambre;
import tn.esprit.spring.seance1.Entities.Foyer;
import tn.esprit.spring.seance1.Repositories.BlocRepository;
import tn.esprit.spring.seance1.Repositories.FoyerRepository;
import tn.esprit.spring.seance1.ServicesInterfaces.FoyerInterface;
import java.util.List;

@AllArgsConstructor
@Service
public class FoyerServicesIMP implements FoyerInterface {
    FoyerRepository foyerRepository;

    public void FoyerServiceIMP(FoyerRepository foyerRepository)
    {
        this.foyerRepository = foyerRepository;
    }

    @Override
    public List<Foyer> retrieveAllFoyers() { return foyerRepository.findAll(); }

    @Override
    public Foyer addFoyer(Foyer f) {
            return foyerRepository.save(f); // Sauvegarde le Foyer dans la base de données
        }

    @Override
    public Foyer updateFoyer(Foyer f) { return foyerRepository.save(f); }

    @Override
    public Foyer retrieveFoyer(long idFoyer) { return foyerRepository.findById(idFoyer).orElse(null); }

    @Override
    public void removeFoyer(long idFoyer) { foyerRepository.deleteById(idFoyer); }

    @Override
    public Foyer getFoyerByUniversiteId(Long idUniversite) {
        return foyerRepository.findFoyerByUniversite_IdUniversite(idUniversite);
    }


}

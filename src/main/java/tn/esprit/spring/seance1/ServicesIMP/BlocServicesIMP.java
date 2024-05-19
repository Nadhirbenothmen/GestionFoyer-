package tn.esprit.spring.seance1.ServicesIMP;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.seance1.Entities.Bloc;
import tn.esprit.spring.seance1.Entities.Foyer;
import tn.esprit.spring.seance1.Entities.Universite;
import tn.esprit.spring.seance1.Repositories.BlocRepository;
import tn.esprit.spring.seance1.Repositories.ChambreRepository;
import tn.esprit.spring.seance1.Repositories.FoyerRepository;
import tn.esprit.spring.seance1.Repositories.UniversiteRepository;
import tn.esprit.spring.seance1.ServicesInterfaces.BlocInterface;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class BlocServicesIMP implements BlocInterface {

    BlocRepository blocRepository ;

    ChambreRepository chambreRepository ;

    UniversiteRepository universiteRepository ;

    FoyerRepository foyerRepository ;

    public void BlocServiceImpl(BlocRepository blocRepository)
    {
        this.blocRepository = blocRepository;
    }
    @Override
    public List<Bloc> retrieveBlocs() { return blocRepository.findAll(); }

    @Override
    public Bloc updateBloc(Bloc bloc) { return blocRepository.save(bloc); }

    @Override
    public Bloc addBloc(Bloc bloc) {
        if (bloc != null) {
            return blocRepository.save(bloc); // Sauvegarde le Bloc dans la base de données
        } else {
            // Gérez le cas où le Bloc est nul
            return null;
        }
    }


    @Override
    public Bloc retrieveBloc(long idBloc) { return blocRepository.findById(idBloc).orElse(null); }

    @Override
    public void removeBloc(long idBloc) { blocRepository.deleteById(idBloc); }
    @Transactional
    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        // Trouver l'université
        Universite u = universiteRepository.findById(idUniversite).orElse(null);
        // Enregistrer le foyer
        foyerRepository.save(foyer);
        // Affecter chaque bloc du foyer au foyer
        for(Bloc bloc:foyer.getBloc()){
            bloc.setFoyer(foyer);
            blocRepository.save(bloc);
        }
        // Associer le foyer à l'université
        u.setFoyer(foyer);
        universiteRepository.save(u);
        return foyer;
    }

    @Override
    public List<Bloc> getBlocsByFoyerId(Long idfoyer) {
        return blocRepository.getBlocsByFoyer_Idfoyer(idfoyer);
    }

    @Override
    public Bloc getBlocByChambreId(Long idChambre) {
        return blocRepository.findBlocByChambre_IdChambre(idChambre);
    }

    @Override
    public Set<Bloc> getBlocsAndUniversiteAdresseByFoyerName(String nomFoyer) {
        Foyer foyer = foyerRepository.findByNomFoyerLike(nomFoyer);
        if (foyer != null) {
            // Vous pouvez accéder aux blocs et à l'adresse de l'université à partir du foyer
            Set<Bloc> blocs = foyer.getBloc();
            String adresseUniversite = (foyer.getUniversite() != null) ? foyer.getUniversite().getAdresse() : null;

            // Faites ce que vous voulez avec les blocs et l'adresse de l'université
            // ...

            return blocs;
        }
        return null; // Handle the case when no foyer is found with the given name
    }
    }


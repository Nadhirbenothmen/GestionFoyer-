package tn.esprit.spring.seance1.ServicesInterfaces;

import tn.esprit.spring.seance1.Entities.Bloc;
import tn.esprit.spring.seance1.Entities.Foyer;

import java.util.List;
import java.util.Set;

public interface BlocInterface {
    List<Bloc> retrieveBlocs();

    Bloc updateBloc(Bloc bloc);

    Bloc addBloc(Bloc bloc);

    Bloc retrieveBloc(long idBloc);

    void removeBloc(long idBloc);

    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite);

    public List<Bloc> getBlocsByFoyerId(Long idfoyer);

    Bloc getBlocByChambreId(Long idChambre);

    public Set<Bloc> getBlocsAndUniversiteAdresseByFoyerName(String nomFoyer) ;
}
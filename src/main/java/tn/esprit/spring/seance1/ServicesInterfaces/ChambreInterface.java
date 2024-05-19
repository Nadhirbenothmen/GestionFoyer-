package tn.esprit.spring.seance1.ServicesInterfaces;

import tn.esprit.spring.seance1.Entities.Bloc;
import tn.esprit.spring.seance1.Entities.Chambre;
import tn.esprit.spring.seance1.Entities.Foyer;
import tn.esprit.spring.seance1.Entities.TypeChambre;


import java.util.List;
import java.util.Set;

public interface ChambreInterface {
    List<Chambre> retrieveAllChambres();

    Chambre addChambre(Chambre c); // ajouter l’équipe avec son détail

    Chambre updateChambre (Chambre c);

    Chambre retrieveChambre (long idChambre);

    public Bloc affecterChambresABloc (List<Long> numChambre, long idBloc) ;

    public List<Chambre> getChambresParNomUniversite( String nomUniversite) ;
    public List<Chambre> getChambresParBlocEtType (long idBloc, TypeChambre typeC) ;

    public List<Chambre> getChambresByBlocId(Long idBloc);
    public List<Chambre> getDoubleChambresWithValidReservations();
    public List<Chambre> getChambresByFoyerWithCapacityGreaterThan(Foyer foyer, Long capacite) ;
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type) ;

           List<Chambre> afficherChambresNonReservees();

    }

package tn.esprit.spring.seance1.ServicesInterfaces;

import tn.esprit.spring.seance1.Entities.Foyer;

import java.util.List;

public interface FoyerInterface {
    List<Foyer> retrieveAllFoyers();

    Foyer addFoyer (Foyer f);

    Foyer updateFoyer (Foyer f);

    Foyer retrieveFoyer (long idFoyer);

    void removeFoyer (long idFoyer);

    Foyer getFoyerByUniversiteId(Long idUniversite);

}

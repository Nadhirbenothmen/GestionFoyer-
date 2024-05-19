package tn.esprit.spring.seance1.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.seance1.Entities.Bloc;
import tn.esprit.spring.seance1.Entities.Chambre;
import tn.esprit.spring.seance1.Entities.Foyer;

import java.util.List;
import java.util.Optional;

@Repository
    public interface FoyerRepository extends JpaRepository <Foyer, Long> {

    Foyer findFoyerByUniversite_IdUniversite(Long idUniversite);

    Foyer findByNomFoyerLike(String nomFoyer);

}

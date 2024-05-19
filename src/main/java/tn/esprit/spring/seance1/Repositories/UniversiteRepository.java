package tn.esprit.spring.seance1.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.seance1.Entities.Foyer;
import tn.esprit.spring.seance1.Entities.Universite;

@Repository
public interface UniversiteRepository extends JpaRepository <Universite, Long> {

        Universite findBynomUniversiteLike(String nomu) ;


}

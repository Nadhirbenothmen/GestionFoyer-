package tn.esprit.spring.seance1.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.seance1.Entities.Bloc;
import tn.esprit.spring.seance1.Entities.Chambre;

import java.util.List;

@Repository
public interface BlocRepository extends JpaRepository<Bloc, Long> {

      List<Bloc> getBlocsByFoyer_Idfoyer(Long idfoyer);

      Bloc findBlocByChambre_IdChambre(Long idChambre);


}

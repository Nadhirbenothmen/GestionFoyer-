package tn.esprit.spring.seance1.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.seance1.Entities.Bloc;
import tn.esprit.spring.seance1.Entities.Chambre;
import tn.esprit.spring.seance1.Entities.Foyer;
import tn.esprit.spring.seance1.Entities.TypeChambre;

import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {

    List<Chambre> findByNumeroChambreIn(List<Long> numeroChambres);

    List<Chambre> findByBlocFoyerUniversiteNomUniversiteLike(String nomUniversite);

    List<Chambre> findByBloc_IdBlocAndTypeC(long idBloc, TypeChambre typeC);
    @Query("Select c From Chambre c where c.bloc.idBloc = :idBloc and c.typeC = :typeC")
    List<Chambre> retieveChambreByidBlocandtypeC(@Param("idBloc") long idBloc, @Param("typeC") TypeChambre typeC);


    List<Chambre> getChambresByBloc_IdBloc(Long idBloc);
    List<Chambre> findByTypeCAndReservations_EstValideTrue(TypeChambre typeC);
    List<Chambre> findByBloc_FoyerAndBloc_Foyer_CapaciteFoyerGreaterThan(Foyer foyer, Long capacite);

    List<Chambre> findByBlocFoyerUniversiteNomUniversiteAndTypeCAndReservations_Empty(String nomUniversite, TypeChambre typeC);

//    @Query("select chambre from Chambre  chambre join "
//            + "chambre.bloc.foyer.universite universite "
//            + "where universite.nomUniversite = :nomUniversite"
//            +  "and (select count(r) from chambre.reservations r ) = 0"
//            + " and chambre.typeC = :typeC")
//    List<Chambre> getChambreNonReserveParNomUniversiteEtTypeC(@Param("nomUniversite");

}

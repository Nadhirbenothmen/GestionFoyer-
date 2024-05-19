package tn.esprit.spring.seance1.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.seance1.Entities.Reservation;
import tn.esprit.spring.seance1.Entities.Universite;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository

public interface ReservationRepository extends JpaRepository <Reservation, Long> {

    List<Reservation> findByEtudiants_Cin(Long cinEtudiant);

    //List<Reservation> findByEtudiants_CinAndEstValideTrue(Long cin);
    //List<Reservation> findByAnneeUniversiteAndChambre_Bloc_Foyer_Universite_Nom(String anneeUniversite, String nomUniversite);
   @Query ("Select r From Reservation r ," +
           " Chambre chambre join chambre.reservations " +
           "join chambre.bloc bloc" +
           " join bloc.foyer foyer" +
           " join foyer.universite " +
           "universite where r.anneeUniversite = :anneeUniversite and  universite.nomUniversite = :nomUniversite ")
    List<Reservation> getReservationParAnneeUniversiteEtNomUniversite(@Param("anneeUniversite")LocalDate anneeUniversite,
                                                                      @Param("nomUniversite")String nomUniversite);

}

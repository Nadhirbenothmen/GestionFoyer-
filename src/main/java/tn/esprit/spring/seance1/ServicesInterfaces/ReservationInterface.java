package tn.esprit.spring.seance1.ServicesInterfaces;

import tn.esprit.spring.seance1.Entities.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface ReservationInterface {
    List<Reservation> retrieveAllReservation();

    Reservation updateReservation (Reservation res);
    Reservation retrieveReservation (long idReservation);

    Reservation ajouterReservation(long idChambre, long cin);
    Reservation annulerReservation(Long cinEtudiant);

    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite( LocalDate anneeUniversite, String nomUniversite) ;

    // public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(LocalDate anneeUniversite, String nomUniversite);

    }

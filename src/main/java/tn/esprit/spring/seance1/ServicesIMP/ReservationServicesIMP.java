package tn.esprit.spring.seance1.ServicesIMP;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.seance1.Entities.*;
import tn.esprit.spring.seance1.Repositories.ChambreRepository;
import tn.esprit.spring.seance1.Repositories.EtudiantRepository;
import tn.esprit.spring.seance1.Repositories.ReservationRepository;
import tn.esprit.spring.seance1.Repositories.UniversiteRepository;
import tn.esprit.spring.seance1.ServicesInterfaces.ReservationInterface;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;


@AllArgsConstructor
@Service

public class ReservationServicesIMP implements ReservationInterface {

    ReservationRepository reservationRepository;
    ChambreRepository chambreRepository;
    EtudiantRepository etudiantRepository;
    UniversiteRepository universiteRepository;

    @Override
    public List<Reservation> retrieveAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation res) {
        return reservationRepository.save(res);
    }

    @Override
    public Reservation retrieveReservation(long idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }

    @Transactional
    @Override
    public Reservation ajouterReservation(long idChambre, long cin) {
        // Trouver chambre
        Chambre chambre = chambreRepository.findById(idChambre).orElse(null);
        // Trouver étudiant
        Etudiant etudiant = etudiantRepository.findByCin(cin).orElse(null);

        if (chambre != null && etudiant != null && !chambreEstPleine(chambre)) {

            Reservation reservation = creerReservation(chambre, etudiant);
            reservationRepository.save(reservation);
            return reservation;
        } else {
            // Gérer le cas où la chambre est pleine ou les entités ne sont pas trouvées
            return null;
        }
    }


    private boolean chambreEstPleine(Chambre chambre) {
        // Obtenez le type de chambre
        TypeChambre typeChambre = chambre.getTypeC();

        // Obtenez la capacité maximale en fonction du type de chambre
        int capaciteMaximale = obtenirCapaciteMaximale(typeChambre);

        // Obtenez la liste des réservations existantes pour cette chambre
        Set<Reservation> reservations = chambre.getReservations();

        // Vérifiez si la capacité maximale est atteinte en comparant avec le nombre de réservations
        return reservations.size() >= capaciteMaximale;
    }

    private int obtenirCapaciteMaximale(TypeChambre typeChambre) {
        // Implémentez la logique pour obtenir la capacité maximale en fonction du type de chambre
        // Par exemple, utilisez une structure de contrôle (switch) pour déterminer la capacité en fonction du type
        switch (typeChambre) {
            case SIMPLE:
                return 1; // Capacité maximale pour une chambre simple
            case DOUBLE:
                return 2; // Capacité maximale pour une chambre double
            case TRIPLE:
                return 3; // Capacité maximale pour une chambre triple
            default:
                return 0; // Gestion d'erreur ou autre logique par défaut
        }
    }

    private Reservation creerReservation(Chambre chambre, Etudiant etudiant) {
        // Créer une instance de la classe Reservation
        Reservation reservation = new Reservation();

        // Remplir les informations nécessaires
        reservation.setAnneeUniversite(LocalDate.now()); // Utilisez la date actuelle, ou toute autre logique nécessaire
        reservation.setEstValide(true); // Selon les consignes spécifiées

        // Associer l'étudiant à la réservation
        Set<Etudiant> etudiants = new HashSet<>();
        etudiants.add(etudiant);
        reservation.setEtudiants(etudiants);

        // Ajouter la réservation à la liste des réservations de la chambre
        Set<Reservation> reservations = chambre.getReservations();
        reservations.add(reservation);
        chambre.setReservations(reservations);

        return reservation;
    }


    @Override
    public Reservation annulerReservation(Long cinEtudiant) {
        List<Reservation> reservations = reservationRepository.findByEtudiants_Cin(cinEtudiant);
        if (!reservations.isEmpty()) {
            Reservation reservation = reservations.get(0);

            // Mettre à jour l'état de la réservation
            reservation.setEstValide(false);

            // Désaffecter l'étudiant associé
            reservation.getEtudiants().clear();

            // Désaffecter la chambre associée et mettre à jour sa capacité
            // Assurez-vous d'adapter cela en fonction de votre modèle de données
            // chambreRepository.desaffecterChambre(reservation.getChambre().getId()); // Exemple

            // Enregistrez les changements dans la base de données
            reservationRepository.save(reservation);

            return reservation;
        } else {
            return  null;
        }
    }

    @Override
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite
            (LocalDate anneeUniversite, String nomUniversite)
    {
        return reservationRepository.getReservationParAnneeUniversiteEtNomUniversite(anneeUniversite,nomUniversite);
    }


}



/*
    @Override
    public Reservation annulerReservation(long cinEtudiant) {
        // Trouver la réservation associée à l'étudiant
        Reservation reservation = reservationRepository.findByEtudiantCinAndEstValideTrue(cinEtudiant).orElse(null);

        // Vérifier si la réservation a été trouvée et si elle est valide
        if (reservation != null && reservation.getEstValide()) {
            // Désaffecter l'étudiant de la réservation
            Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant).orElse(null);
            if (etudiant != null) {
                reservation.getEtudiants().remove(etudiant);
            }
            // Marquer la réservation comme non valide
            reservation.setEstValide(false);
            // Enregistrez la réservation mise à jour
            reservationRepository.save(reservation);
            return reservation;
        } else {
            // Gérer le cas où la réservation n'est pas trouvée ou n'est pas valide
            return null;
        }
    }*/
/*
    @Override
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(LocalDate anneeUniversite, String nomUniversite)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy"); // Utilisez le format approprié pour l'année
        String anneeUniversiteStr = sdf.format(anneeUniversite);
        return reservationRepository.findByAnneeUniversiteAndChambre_Bloc_Foyer_Universite_Nom(anneeUniversiteStr,nomUniversite);
    }   */

    //  private String generateId(chambre,)


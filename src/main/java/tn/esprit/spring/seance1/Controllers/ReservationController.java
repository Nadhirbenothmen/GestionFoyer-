package tn.esprit.spring.seance1.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.seance1.Entities.Reservation;
import tn.esprit.spring.seance1.ServicesInterfaces.ReservationInterface;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/ReservationC")
public class ReservationController {

    @GetMapping("/retrieveAllReservation")
    public List<Reservation> retrieveAllReservation() { return reservationInterface.retrieveAllReservation(); }

    @PutMapping("/updateReservation")
    public Reservation updateReservation(@RequestBody Reservation res)
        {
            return reservationInterface.updateReservation(res);
        }

    @GetMapping("/findreservationbyid/{idReservation}")
    public Reservation retrieveReservation(@PathVariable long idReservation)
    {
        return reservationInterface.retrieveReservation(idReservation);
    }
    @PutMapping("/ajouterReservation/{idChambre}/{cin}")
    public Reservation ajouterReservation(@PathVariable long idChambre,@PathVariable long cin)
    {
        return reservationInterface.ajouterReservation(idChambre, cin);
    }

    @PutMapping("/annulerReservation/{cinEtudiant}")
    public Reservation annulerReservation(@PathVariable long cinEtudiant)
    {
        return reservationInterface.annulerReservation(cinEtudiant);
    }


    @PutMapping("/getReservationParAnneeUniversitaireEtNomUniversite/{anneeUniversite}/{nomUniversite}")
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite
        (@PathVariable("anneeUniversite")
         @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  LocalDate anneeUniversite
        , @PathVariable String nomUniversite)
        {
        return reservationInterface.getReservationParAnneeUniversitaireEtNomUniversite( anneeUniversite, nomUniversite);
        }

    /*
        @PutMapping("/getReservationParAnneeUniversitaireEtNomUniversite/{anneeUniversite}/{nomUniversite}")
        public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(@RequestBody @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate anneeUniversite, @PathVariable String nomUniversite) {
            return reservationInterface.getReservationParAnneeUniversitaireEtNomUniversite(anneeUniversite, nomUniversite);
        }
        */
    ReservationInterface reservationInterface ;
}

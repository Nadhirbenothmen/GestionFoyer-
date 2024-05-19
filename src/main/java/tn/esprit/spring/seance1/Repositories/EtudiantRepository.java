package tn.esprit.spring.seance1.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.seance1.Entities.Etudiant;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EtudiantRepository extends JpaRepository <Etudiant, Long> {
    Optional<Etudiant> findByCin(Long cin);
    List<Etudiant> findByReservations_AnneeUniversite(LocalDate anneeUniversite);

}

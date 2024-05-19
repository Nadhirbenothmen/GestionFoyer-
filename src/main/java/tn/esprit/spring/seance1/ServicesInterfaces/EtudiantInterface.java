package tn.esprit.spring.seance1.ServicesInterfaces;

import tn.esprit.spring.seance1.Entities.Etudiant;

import java.util.List;

public interface  EtudiantInterface {
    List<Etudiant> retrieveAllEtudiants();
    List<Etudiant> addEtudiants (List<Etudiant> etudiants);
    Etudiant updateEtudiant (Etudiant e);
    Etudiant retrieveEtudiant(long idEtudiant);
    void removeEtudiant(long idEtudiant);

    public List<Etudiant> getEtudiantsByCurrentAcademicYear();
}

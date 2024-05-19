package tn.esprit.spring.seance1.ServicesInterfaces;

import tn.esprit.spring.seance1.Entities.Universite;

import java.util.List;

public interface UniversiteInterface {
    List<Universite> retrieveAllUniversities();

    Universite addUniversity (Universite u);

    Universite updateUniversity (Universite u);

    Universite retrieveUniversity (long idUniversity);

    public Universite affecterFoyerAUniversite (long idFoyer, String nomUniversite) ;
    public Universite desaffecterFoyerAUniversite (long idUniversite) ;
}

package tn.esprit.spring.seance1.ServicesIMP;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.spring.seance1.Entities.Bloc;
import tn.esprit.spring.seance1.Entities.Chambre;
import tn.esprit.spring.seance1.Entities.Foyer;
import tn.esprit.spring.seance1.Entities.TypeChambre;
import tn.esprit.spring.seance1.Repositories.BlocRepository;
import tn.esprit.spring.seance1.Repositories.ChambreRepository;
import tn.esprit.spring.seance1.Repositories.UniversiteRepository;
import tn.esprit.spring.seance1.ServicesInterfaces.ChambreInterface;

import java.util.ArrayList;
import java.util.List;


import java.util.Set;

@AllArgsConstructor
@Service
@Slf4j

public class ChambreServicesIMP implements ChambreInterface {

    ChambreRepository chambreRepository ;

    BlocRepository blocRepository ;



    public void ChambreServiceIMP(ChambreRepository chambreRepository)
    {
        this.chambreRepository = chambreRepository;
    }
    @Override
    public List<Chambre> retrieveAllChambres() { return chambreRepository.findAll(); }

    @Override
    public Chambre addChambre(Chambre c) {
        if (c != null) {
            return chambreRepository.save(c); // Sauvegarde le Bloc dans la base de données
        } else {
            // Gérez le cas où le Bloc est nul
            return null;
        }
    }

    @Override
    public Chambre updateChambre(Chambre c) { return chambreRepository.save(c); }

    @Override
    public Chambre retrieveChambre(long idChambre) {
        return chambreRepository.findById(idChambre).orElse(null);
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        // Trouver le bloc
        Bloc b = blocRepository.findById(idBloc).orElse(null);
        // Trouver les chambres
        List<Chambre> chambres = chambreRepository.findByNumeroChambreIn(numChambre);
        // Associer les chambres au bloc
        for (Chambre chambre:chambres){
            chambre.setBloc(b);
            chambreRepository.save(chambre);
        }
        return  b ;
    }

    @Override
    public List<Chambre> getChambresParNomUniversite(String nomUniversite)
    {
        return chambreRepository.findByBlocFoyerUniversiteNomUniversiteLike(nomUniversite);
    }

    @Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC) {
        return chambreRepository.retieveChambreByidBlocandtypeC(idBloc,typeC);
    }

    @Override
    public List<Chambre> getChambresByBlocId(Long idBloc) {
        return chambreRepository.getChambresByBloc_IdBloc(idBloc);
    }

    @Override
    public List<Chambre> getDoubleChambresWithValidReservations() {
        return chambreRepository.findByTypeCAndReservations_EstValideTrue(TypeChambre.DOUBLE);
    }

    @Override
    public List<Chambre> getChambresByFoyerWithCapacityGreaterThan(Foyer foyer, Long capacite)
    {
        return chambreRepository.findByBloc_FoyerAndBloc_Foyer_CapaciteFoyerGreaterThan(foyer,capacite);
    }

    @Override
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type)
    {
        return chambreRepository.findByBlocFoyerUniversiteNomUniversiteAndTypeCAndReservations_Empty(nomUniversite,type);
    }

    @Override
    public List<Chambre> afficherChambresNonReservees() {
        List<Chambre> chambres = chambreRepository.findAll();

        // les chambres non reservées
        List<Chambre> chambresNonReservees = new ArrayList<>();
        for (Chambre chambre : chambres){
            if (chambre.getReservations().isEmpty()){
                chambresNonReservees.add(chambre);
            }
        }
        return chambresNonReservees;
    }

    @Scheduled(cron = "*/5 * * * * *" )
    public void cronMethod() {
        List<Chambre> chambresNonReservees = afficherChambresNonReservees();
        for(Chambre chambre : chambresNonReservees) {
          // log.info("Chambre non réservée:", chambre.toString() + "tessssst");
           // log.info("--------------------");
           System.out.println("Chambre non réservée" + chambre);
        }
    }


}

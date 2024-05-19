package tn.esprit.spring.seance1.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Chambre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long idChambre;
     Long numeroChambre;

    /*Enumération*/
    @Enumerated(EnumType.STRING)
     TypeChambre typeC;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    Bloc bloc ;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(fetch = FetchType.EAGER)
    Set<Reservation> reservations ;



}

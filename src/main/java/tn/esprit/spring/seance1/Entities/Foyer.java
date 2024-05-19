package tn.esprit.spring.seance1.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Foyer implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   //@column(name="idfoyer")

     Long idfoyer;

     String nomFoyer;

     Long capaciteFoyer;


     @JsonIgnore

    @OneToOne(mappedBy = "foyer")
    Universite universite ;

    //@JsonIgnore
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "foyer")
    Set<Bloc> bloc ;


}

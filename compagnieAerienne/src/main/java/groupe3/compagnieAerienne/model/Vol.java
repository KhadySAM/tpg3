package groupe3.compagnieAerienne.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "vol")
public class Vol {

    //les attributs
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String villeDepart;
    private String villeArrive;


}















   /* //les jointures
    @JoinColumn(name = "id_avion")
    @OneToMany
    private Avion avion;

    @JoinColumn(name = "id_voyage")
    @OneToOne
    private Voyage voyage;*/
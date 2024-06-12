package groupe3.compagnieAerienne.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "voyage")
public class Voyage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long numVoyage;
    private Date dateVoyage;


}








/*

    @JoinColumn(name = "id_equipage")
    @OneToMany
    private Equipage equipage;*/

package groupe3.compagnieAerienne.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "escale")
public class Escale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long numEscale;
    private String aeredrome;


}







/*
    //les jointure@JoinColumn(name = "id_vol")
    @OneToMany
    Vol vol;*/

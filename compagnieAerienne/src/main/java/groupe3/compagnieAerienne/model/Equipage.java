package groupe3.compagnieAerienne.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "equipage")
public class Equipage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long numEquipage;
    private Long numCommandant;
    private Long numCopilote;
    private Long numMecanicien;
    private Long numHotesse;


}










/*
    @OneToMany(mappedBy = "equipage")
    @JsonIgnore
    private List<Membre> membre;*/

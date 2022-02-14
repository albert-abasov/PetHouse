package ua.abasov.coursework.pethouse.pet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pet {
    @Id
    @SequenceGenerator(sequenceName = "pets_id_seq", name = "generator", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    private int id;
    private String name;
    private String type;
    private String breed;
    private int petOwnerId;
    private String description;
    private boolean specialDiet;


}

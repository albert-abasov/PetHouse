package ua.abasov.coursework.pethouse.pet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
//    @Id
//    @SequenceGenerator(sequenceName = "pets_id_seq", name = "generator", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    private int id;
    private String name;
    private PetType type;
    private String breed;
    private int petOwnerId;
    private String description;
    private boolean specialDiet;

    public Pet(String name, PetType type, String breed, int petOwnerId,
               String description, boolean specialDiet) {
        this.name = name;
        this.type = type;
        this.breed = breed;
        this.petOwnerId = petOwnerId;
        this.description = description;
        this.specialDiet = specialDiet;
    }
}

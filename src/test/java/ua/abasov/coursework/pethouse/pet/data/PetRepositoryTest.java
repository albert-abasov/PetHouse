package ua.abasov.coursework.pethouse.pet.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.abasov.coursework.pethouse.pet.model.PetType;
import ua.abasov.coursework.pethouse.pet.model.Pet;
import ua.abasov.coursework.pethouse.pet_owner.data.PetOwnerRepository;
import ua.abasov.coursework.pethouse.pet_owner.model.PetOwner;

import java.util.List;

@SpringBootTest
public class PetRepositoryTest {
    @Autowired
    private PetRepository petRepository;
    @Autowired
    private PetOwnerRepository petOwnerRepository;

    @Test
    public void getAnimalTest() {
        List<Pet> pets = petRepository.getPets();
        Assertions.assertEquals(0, pets.size());
    }

    @Test
    void createAnimal() {
        PetOwner petOwner = new PetOwner(1, "name", "sur", "+380631234563", "add");
        petOwnerRepository.createPetOwner(petOwner);

        Pet pet = new Pet("name", PetType.CAT, "breed", 1,
                "description", true);

        petRepository.createPet(pet);

        List<Pet> pets = petRepository.getPets();
        Assertions.assertEquals(1, pets.size());
        pet.setId(1);
        Assertions.assertEquals(pet, pets.get(0));
    }
}

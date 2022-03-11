package ua.abasov.coursework.pethouse.pet_owner.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.abasov.coursework.pethouse.pet_owner.model.PetOwner;
import ua.abasov.coursework.pethouse.pet_owner.service.PetOwnerService;

@SpringBootTest
public class PetOwnerRepositoryTest {
    @Autowired
    private PetOwnerRepository petOwnerRepository;

    @Autowired
    private PetOwnerService petOwnerService;

    @Test
    void updatePartOfPetOwner() {
        PetOwner updatedPetOwner = new PetOwner();
        updatedPetOwner.setName("new name");
        updatedPetOwner.setAddress("new address");

        petOwnerService.updatePartOfPetOwner(1, updatedPetOwner);

        PetOwner petOwner = petOwnerService.getPetOwner(1);

        Assertions.assertEquals(updatedPetOwner.getName(), petOwner.getName());
    }

}

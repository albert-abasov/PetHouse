package ua.abasov.coursework.pethouse.pet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.abasov.coursework.pethouse.pet.data.PetRepository;
import ua.abasov.coursework.pethouse.pet.model.Pet;

import java.util.List;

@Service
public class PetService {
    private PetRepository petRepository;

    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> getPets() {
        return petRepository.getPets();
    }

    public Pet getPet(int id) {
        return petRepository.getPet(id);
    }

    public Pet createPet(Pet pet) {
        return petRepository.createPet(pet);
    }

    public Pet updatePet(int id, Pet updatedPet) {
        return petRepository.updatePet(id, updatedPet);
    }

    public Pet updatePartOfPet(int id, Pet updatedPet) {
        Pet pet = petRepository.getPet(id);

        if (updatedPet.getName() != null) {
            pet.setName(updatedPet.getName());
        }

        if (updatedPet.getBreed() != null) {
            pet.setBreed(updatedPet.getBreed());
        }

        if (updatedPet.getType() != null) {
            pet.setType(updatedPet.getType());
        }

        if (updatedPet.getDescription() != null) {
            pet.setDescription(updatedPet.getDescription());
        }

        if (updatedPet.isSpecialDiet() != pet.isSpecialDiet()) {
            pet.setSpecialDiet(updatedPet.isSpecialDiet());
        }

        if (updatedPet.getPetOwnerId() != 0) {
            pet.setPetOwnerId(updatedPet.getPetOwnerId());
        }

        petRepository.updatePet(id, pet);
        return pet;
    }

    public void deletePet(int id) {
        petRepository.deletePet(id);
    }
}

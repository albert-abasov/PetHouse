package ua.abasov.coursework.pethouse.pet_owner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.abasov.coursework.pethouse.pet_owner.data.PetOwnerRepository;
import ua.abasov.coursework.pethouse.pet_owner.model.PetOwner;

import java.util.List;

@Service
public class PetOwnerService {
    private PetOwnerRepository petOwnerRepository;

    @Autowired
    public PetOwnerService(PetOwnerRepository petOwnerRepository) {
        this.petOwnerRepository = petOwnerRepository;
    }

    public List<PetOwner> getPetOwners() {
        return petOwnerRepository.getPetOwners();
    }

    public PetOwner getPetOwner(int id) {
        return petOwnerRepository.getPetOwner(id);
    }

    public PetOwner createPetOwner(PetOwner petOwner) {
        return petOwnerRepository.createPetOwner(petOwner);
    }

    public PetOwner updatePetOwner(int id, PetOwner updatedPetOwner) {
        return petOwnerRepository.updatePetOwner(id, updatedPetOwner);
    }

    public PetOwner updatePartOfPetOwner(int id, PetOwner updatedPetOwner) {
        PetOwner petOwner = petOwnerRepository.getPetOwner(id);

        if (updatedPetOwner.getName() != null) {
            petOwner.setName(updatedPetOwner.getName());
        }

        if (updatedPetOwner.getSurname() != null) {
            petOwner.setSurname(updatedPetOwner.getSurname());
        }

        if (updatedPetOwner.getAddress() != null) {
            petOwner.setAddress(updatedPetOwner.getAddress());
        }

        if (updatedPetOwner.getPhoneNumber() != null) {
            petOwner.setPhoneNumber(updatedPetOwner.getPhoneNumber());
        }

        petOwnerRepository.updatePetOwner(id, petOwner);
        return petOwner;
    }

    public void deletePetOwner(int id) {
        petOwnerRepository.deletePetOwner(id);
    }
}

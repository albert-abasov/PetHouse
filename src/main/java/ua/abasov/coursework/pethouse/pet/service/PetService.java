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
}

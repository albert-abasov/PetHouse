package ua.abasov.coursework.pethouse.pet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.abasov.coursework.pethouse.pet.model.Pet;
import ua.abasov.coursework.pethouse.pet.service.PetService;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {
    private PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public List<Pet> getPets() {
        return petService.getPets();
    }

    @GetMapping("/{id}")
    public Pet getPet(@PathVariable int id) {
        return petService.getPet(id);
    }

    @PostMapping
    public Pet createPet(@RequestBody Pet pet) {
        return petService.createPet(pet);
    }

    @PutMapping("/{id}")
    public Pet updatePet(@PathVariable int id, @RequestBody Pet pet) {
        return petService.updatePet(pet, id);
    }

    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable int id) {
        petService.deletePet(id);
    }
}

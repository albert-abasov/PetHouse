package ua.abasov.coursework.pethouse.pet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ua.abasov.coursework.pethouse.pet.model.Pet;
import ua.abasov.coursework.pethouse.pet.service.PetService;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetController {
    private PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    @PreAuthorize("hasRole('EMPLOYEE') or hasRole('ADMIN')")
    public List<Pet> getPets() {
        return petService.getPets();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('EMPLOYEE') or hasRole('ADMIN')")
    public Pet getPet(@PathVariable int id) {
        return petService.getPet(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('EMPLOYEE') or hasRole('ADMIN')")
    public Pet createPet(@RequestBody Pet pet) {
        return petService.createPet(pet);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('EMPLOYEE') or hasRole('ADMIN')")
    public Pet updatePet(@PathVariable int id, @RequestBody Pet updatedPet) {
        return petService.updatePet(id, updatedPet);
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasRole('EMPLOYEE') or hasRole('ADMIN')")
    public Pet updatePartOfPet(@PathVariable int id, @RequestBody Pet updatedPet) {
        return petService.updatePartOfPet(id, updatedPet);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('EMPLOYEE') or hasRole('ADMIN')")
    public void deletePet(@PathVariable int id) {
        petService.deletePet(id);
    }
}

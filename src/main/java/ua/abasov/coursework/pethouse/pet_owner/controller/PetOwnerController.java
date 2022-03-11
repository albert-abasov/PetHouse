package ua.abasov.coursework.pethouse.pet_owner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ua.abasov.coursework.pethouse.pet.model.Pet;
import ua.abasov.coursework.pethouse.pet_owner.model.PetOwner;
import ua.abasov.coursework.pethouse.pet_owner.service.PetOwnerService;

import java.util.List;

@RestController
@RequestMapping("/api/pet_owners")
public class PetOwnerController {
    private PetOwnerService petOwnerService;

    @Autowired
    public PetOwnerController(PetOwnerService petOwnerService) {
        this.petOwnerService = petOwnerService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<PetOwner> getPetOwners() {
        return petOwnerService.getPetOwners();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public PetOwner getPetOwner(@PathVariable int id) {
        return petOwnerService.getPetOwner(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public PetOwner createPetOwner(@RequestBody PetOwner petOwner) {
        return petOwnerService.createPetOwner(petOwner);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public PetOwner updatePetOwner(@PathVariable int id, @RequestBody PetOwner updatedPetOwner) {
        return petOwnerService.updatePetOwner(id, updatedPetOwner);
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public PetOwner updatePartOfThePet(@PathVariable int id, @RequestBody PetOwner updatedPetOwner) {
        return petOwnerService.updatePartOfPetOwner(id, updatedPetOwner);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deletePetOwner(@PathVariable int id) {
        petOwnerService.deletePetOwner(id);
    }
}

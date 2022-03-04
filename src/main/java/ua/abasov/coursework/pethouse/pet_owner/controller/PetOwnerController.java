package ua.abasov.coursework.pethouse.pet_owner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.abasov.coursework.pethouse.pet_owner.model.PetOwner;
import ua.abasov.coursework.pethouse.pet_owner.service.PetOwnerService;

import java.util.List;

@RestController
@RequestMapping("/pet_owners")
public class PetOwnerController {
    private PetOwnerService petOwnerService;

    @Autowired
    public PetOwnerController(PetOwnerService petOwnerService) {
        this.petOwnerService = petOwnerService;
    }

    @GetMapping
    public List<PetOwner> getPetOwners() {
        return petOwnerService.getPetOwners();
    }

    @GetMapping("/{id}")
    public PetOwner getPetOwner(@PathVariable int id) {
        return petOwnerService.getPetOwner(id);
    }

    @PostMapping
    public PetOwner createPetOwner(@RequestBody PetOwner petOwner) {
        return petOwnerService.createPetOwner(petOwner);
    }

    @PutMapping("/{id}")
    public PetOwner updatePetOwner(@PathVariable int id, @RequestBody PetOwner updatedPetOwner) {
        return petOwnerService.updatePetOwner(id, updatedPetOwner);
    }

    @DeleteMapping("/{id}")
    public void deletePetOwner(@PathVariable int id) {
        petOwnerService.deletePetOwner(id);
    }
}

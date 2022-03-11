package ua.abasov.coursework.pethouse.accommodation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ua.abasov.coursework.pethouse.accommodation.model.Accommodation;
import ua.abasov.coursework.pethouse.accommodation.service.AccommodationService;

import java.util.List;

@RestController
@RequestMapping("/api/accommodation")
public class AccommodationController {
    private AccommodationService accommodationService;

    @Autowired
    public AccommodationController(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @GetMapping
    public List<Accommodation> getAccommodation() {
        return accommodationService.getAccommodation();
    }

    @GetMapping("/{id}")
    public Accommodation getAccommodationById(@PathVariable int id) {
        return accommodationService.getAccommodationById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('EMPLOYEE') or hasRole('ADMIN')")
    public Accommodation createAccommodation(Accommodation accommodation) {
        return accommodationService.createAccommodation(accommodation);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('EMPLOYEE') or hasRole('ADMIN')")
    public Accommodation updateAccommodation(@PathVariable int id, @RequestBody Accommodation updatedAccommodation) {
        return accommodationService.updateAccommodation(id, updatedAccommodation);
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasRole('EMPLOYEE') or hasRole('ADMIN')")
    public Accommodation updatePartOfAccommodation(@PathVariable int id,
                                                   @RequestBody Accommodation updatedAccommodation) {
       return accommodationService.updatePartOfAccommodation(id, updatedAccommodation);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('EMPLOYEE') or hasRole('ADMIN')")
    public void deleteAccommodation(@PathVariable int id) {
        accommodationService.deleteAccommodation(id);
    }
}

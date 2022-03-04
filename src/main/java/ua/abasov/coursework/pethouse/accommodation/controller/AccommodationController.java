package ua.abasov.coursework.pethouse.accommodation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.abasov.coursework.pethouse.accommodation.model.Accommodation;
import ua.abasov.coursework.pethouse.accommodation.service.AccommodationService;

import java.util.List;

@RestController
@RequestMapping("/accommodation")
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
    public Accommodation createAccommodation(Accommodation accommodation) {
        return accommodationService.createAccommodation(accommodation);
    }


}

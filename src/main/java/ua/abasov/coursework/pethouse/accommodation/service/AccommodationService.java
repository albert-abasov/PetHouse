package ua.abasov.coursework.pethouse.accommodation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.abasov.coursework.pethouse.accommodation.data.AccommodationRepository;
import ua.abasov.coursework.pethouse.accommodation.model.Accommodation;

import java.util.List;

@Service
public class AccommodationService {
    private AccommodationRepository accommodationRepository;

    @Autowired
    public AccommodationService(AccommodationRepository accommodationRepository) {
        this.accommodationRepository = accommodationRepository;
    }

    public List<Accommodation> getAccommodation() {
        return accommodationRepository.getAccommodation();
    }

    public Accommodation getAccommodationById(int id) {
        return accommodationRepository.getAccommodationById(id);
    }

    public Accommodation createAccommodation(Accommodation accommodation) {
        return accommodationRepository.createAccommodation(accommodation);
    }

    public Accommodation updateAccommodation(int id, Accommodation newAccommodation) {
        return accommodationRepository.updateAccommodation(id, newAccommodation);
    }

    public void deleteAccommodation(int id) {
        accommodationRepository.deleteAccommodation(id);
    }
}

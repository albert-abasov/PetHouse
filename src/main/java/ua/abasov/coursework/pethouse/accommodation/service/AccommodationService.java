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

    public Accommodation updateAccommodation(int id, Accommodation updatedAccommodation) {
        return accommodationRepository.updateAccommodation(id, updatedAccommodation);
    }

    public Accommodation updatePartOfAccommodation(int id, Accommodation updatedAccommodation) {
        Accommodation accommodation = accommodationRepository.getAccommodationById(id);

        if (updatedAccommodation.getCheckInDate() != null) {
            accommodation.setCheckInDate(updatedAccommodation.getCheckInDate());
        }

        if (updatedAccommodation.getEvictionDate() != null) {
            accommodation.setEvictionDate(updatedAccommodation.getEvictionDate());
        }

        if (updatedAccommodation.getCaredById() != 0) {
            accommodation.setCaredById(updatedAccommodation.getCaredById());
        }

        if (updatedAccommodation.getPetId() != 0) {
            accommodation.setPetId(updatedAccommodation.getPetId());
        }

        if (updatedAccommodation.getRoomId() != 0) {
            accommodation.setRoomId(updatedAccommodation.getRoomId());
        }

        accommodationRepository.updateAccommodation(id, accommodation);
        return accommodation;
    }

    public void deleteAccommodation(int id) {
        accommodationRepository.deleteAccommodation(id);
    }
}

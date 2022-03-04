package ua.abasov.coursework.pethouse.accommodation.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.abasov.coursework.pethouse.accommodation.model.Accommodation;

import java.util.List;

@Repository
public class AccommodationRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AccommodationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Accommodation> getAccommodation() {
        return jdbcTemplate.query("SELECT * FROM accommodation",
                new BeanPropertyRowMapper<>(Accommodation.class));
    }

    public Accommodation getAccommodationById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM accommodation WHERE id = ?",
                new BeanPropertyRowMapper<>(Accommodation.class), id);
    }

    public Accommodation createAccommodation(Accommodation accommodation) {
        jdbcTemplate.update("INSERT INTO accommodation(checkInDate, evictionDate, caredById," +
                        "petId, roomId) VALUES(?, ?, ?, ?, ?)",
                accommodation.getCheckInDate(), accommodation.getEvictionDate(), accommodation.getCaredById(),
                accommodation.getPetId(), accommodation.getRoomId());

        return accommodation;
    }

    public Accommodation updateAccommodation(int id, Accommodation newAccommodation) {
        jdbcTemplate.update("UPDATE accommodation SET checkInDate = ?, evictionDate = ?," +
                        "caredById = ?, petId = ?, roomId = ? WHERE id = ?",
                newAccommodation.getCheckInDate(), newAccommodation.getEvictionDate(),
                newAccommodation.getCaredById(), newAccommodation.getPetId(), newAccommodation.getRoomId(), id);

        return newAccommodation;
    }

    public void deleteAccommodation(int id) {
        jdbcTemplate.update("DELETE FROM accommodation WHERE id = ?", id);
    }
}

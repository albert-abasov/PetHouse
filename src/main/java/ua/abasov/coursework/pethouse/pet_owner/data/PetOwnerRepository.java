package ua.abasov.coursework.pethouse.pet_owner.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.abasov.coursework.pethouse.pet_owner.model.PetOwner;

import java.util.List;

@Repository
public class PetOwnerRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PetOwnerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<PetOwner> getPetOwners() {
        return jdbcTemplate.query("SELECT * FROM pet_owners",
                new BeanPropertyRowMapper<>(PetOwner.class));
    }

    public PetOwner getPetOwner(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM pet_owners WHERE id = ?",
                new BeanPropertyRowMapper<>(PetOwner.class), id);
    }

    public PetOwner createPetOwner(PetOwner petOwner) {
        jdbcTemplate.update("INSERT INTO pet_owners VALUES (?, ?, ?, ?, ?)",
                petOwner.getId(), petOwner.getName(), petOwner.getSurname(),
                petOwner.getPhoneNumber(), petOwner.getAddress());
        return petOwner;
    }

    public PetOwner updatePetOwner(int id, PetOwner updatedPetOwner) {
        jdbcTemplate.update("UPDATE pet_owners SET name = ?, surname = ?," +
                        "phone_number = ?, address = ?", updatedPetOwner.getName(),
                updatedPetOwner.getSurname(), updatedPetOwner.getPhoneNumber(),
                updatedPetOwner.getAddress(), id);

        return updatedPetOwner;
    }

    public void deletePetOwner(int id) {
        jdbcTemplate.update("DELETE FROM pet_owners WHERE id = ?", id);
    }
}

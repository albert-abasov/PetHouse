package ua.abasov.coursework.pethouse.pet.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.abasov.coursework.pethouse.pet.model.Pet;

import java.util.List;

@Repository
public class PetRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PetRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Pet> getPets() {
        return jdbcTemplate.query("SELECT * FROM pets", new BeanPropertyRowMapper<>(Pet.class));
    }

    public Pet getPet(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM pets WHERE id = ?",
                new BeanPropertyRowMapper<>(Pet.class), id);
    }

    public Pet createPet(Pet pet) {
        jdbcTemplate.update("INSERT INTO pets(name, type, breed, pet_owner_id, description, special_diet) " +
                        "VALUES (?, ?, ?, ?, ?, ?)",
                pet.getName(), pet.getType().name(), pet.getBreed(),
                pet.getPetOwnerId(), pet.getDescription(), pet.isSpecialDiet());
        return pet;
    }

    public Pet updatePet(int id, Pet updatedPet) {
        jdbcTemplate.update("UPDATE pets SET name = ?, type = ?, breed = ?, " +
                        "pet_owner_id = ?, description = ?, special_diet = ? WHERE id = ?",
                updatedPet.getName(), updatedPet.getType().name(), updatedPet.getBreed(),
                updatedPet.getPetOwnerId(), updatedPet.getDescription(), updatedPet.isSpecialDiet(), id);

        return updatedPet;
    }

    public void deletePet(int id) {
        jdbcTemplate.update("DELETE FROM pets WHERE id = ?", id);
    }
}

package ua.abasov.coursework.pethouse.pet.data;

import org.springframework.jdbc.core.RowMapper;
import ua.abasov.coursework.pethouse.pet.model.Pet;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PetRowMapper implements RowMapper<Pet> {
    @Override
    public Pet mapRow(ResultSet rs, int rowNum) throws SQLException {
        Pet pet = new Pet();

        pet.setId(rs.getInt("id"));
        pet.setName(rs.getString("name"));
        pet.setBreed(rs.getString("breed"));
        pet.setPetOwnerId(rs.getInt("pet_owner_id"));
        pet.setDescription(rs.getString("description"));
        pet.setSpecialDiet(rs.getBoolean("special_diet"));

        return pet;
    }
}

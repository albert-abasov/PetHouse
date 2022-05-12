package ua.abasov.coursework.pethouse.room.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.abasov.coursework.pethouse.room.model.Room;

import java.util.List;

@Repository
public class RoomRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public RoomRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Room> getRooms() {
        return jdbcTemplate.query("SELECT * FROM rooms",
                new BeanPropertyRowMapper<>(Room.class));
    }

    public Room getRoom(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM rooms WHERE id = ?",
                new BeanPropertyRowMapper<>(Room.class), id);
    }

    public Room createRoom(Room room) {
        jdbcTemplate.update("INSERT INTO rooms(type, price) VALUES(cast(? as pet_type), ?)",
                room.getType().name(), room.getPrice());

        return room;
    }

    public Room updateRoom(int id, Room updatedRoom) {
        jdbcTemplate.update("UPDATE rooms SET type = cast(? as pet_type), price = ? WHERE id = ?",
                updatedRoom.getType().name(), updatedRoom.getPrice(), id);

        return updatedRoom;
    }

    public void deleteRoom(int id) {
        jdbcTemplate.update("DELETE FROM rooms WHERE id = ?", id);
    }
}

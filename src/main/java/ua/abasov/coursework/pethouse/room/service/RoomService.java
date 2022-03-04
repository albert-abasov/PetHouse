package ua.abasov.coursework.pethouse.room.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.abasov.coursework.pethouse.room.data.RoomRepository;
import ua.abasov.coursework.pethouse.room.model.Room;

import java.util.List;

@Service
public class RoomService {
    private RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getRooms() {
        return roomRepository.getRooms();
    }

    public Room getRoom(int id) {
        return roomRepository.getRoom(id);
    }

    public Room createRoom(Room room) {
        return roomRepository.createRoom(room);
    }

    public Room updateRoom(int id, Room newRoom) {
        return roomRepository.updateRoom(id, newRoom);
    }

    public void deleteRoom(int id) {
        roomRepository.deleteRoom(id);
    }
}

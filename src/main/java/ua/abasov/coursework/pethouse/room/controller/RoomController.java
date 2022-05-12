package ua.abasov.coursework.pethouse.room.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ua.abasov.coursework.pethouse.room.model.Room;
import ua.abasov.coursework.pethouse.room.service.RoomService;

import java.util.List;

@RestController
@RequestMapping("api/rooms")
public class RoomController {
    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<Room> getRooms() {
        return roomService.getRooms();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','EMPLOYEE')")
    public Room getRoom(@PathVariable int id) {
        return roomService.getRoom(id);
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','EMPLOYEE')")
    public Room createRoom(@RequestBody Room room) {
        return roomService.createRoom(room);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('EMPLOYEE') or hasRole('ADMIN')")
    public Room updateRoom(@PathVariable int id, @RequestBody Room upadtedRoom) {
        return roomService.updateRoom(id, upadtedRoom);
    }

    @PatchMapping("/{id}")
    public Room updatePartOfRoom(@PathVariable int id, @RequestBody Room updatedRoom) {
        return roomService.updatePartOfRoom(id, updatedRoom);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('EMPLOYEE') or hasRole('ADMIN')")
    public void deleteRoom(@PathVariable int id) {
        roomService.deleteRoom(id);
    }
}

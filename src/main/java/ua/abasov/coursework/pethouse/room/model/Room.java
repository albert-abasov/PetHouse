package ua.abasov.coursework.pethouse.room.model;

import lombok.Data;
import ua.abasov.coursework.pethouse.pet.model.PetType;

@Data
public class Room {
    private int id;
    private PetType type;
    private int price;
}

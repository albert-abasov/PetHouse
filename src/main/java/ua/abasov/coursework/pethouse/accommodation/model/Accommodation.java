package ua.abasov.coursework.pethouse.accommodation.model;

import lombok.Data;

import java.time.Instant;


@Data
public class Accommodation {
    private int id;
    private Instant checkInDate; // localdate (without time)
    private Instant evictionDate; // localdate (without time)
    private int caredById;
    private int petId;
    private int roomId;
}

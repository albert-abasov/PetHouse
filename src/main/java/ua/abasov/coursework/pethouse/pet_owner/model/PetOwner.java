package ua.abasov.coursework.pethouse.pet_owner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetOwner {
    private int id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String address;
}

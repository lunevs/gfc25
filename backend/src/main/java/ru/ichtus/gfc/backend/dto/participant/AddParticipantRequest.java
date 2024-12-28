package ru.ichtus.gfc.backend.dto.participant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddParticipantRequest {

    String name;
    String surname;
    String city;
    String phone;

}
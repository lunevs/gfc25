package ru.ichtus.gfc.backend.dto.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddEventItemRequest {
    Integer eventId;
    Integer participantId;
    String role;
    String title;
}

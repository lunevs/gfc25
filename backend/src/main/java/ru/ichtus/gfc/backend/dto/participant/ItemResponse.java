package ru.ichtus.gfc.backend.dto.participant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ichtus.gfc.backend.model.Participant;
import ru.ichtus.gfc.backend.model.dictionary.ParticipationType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponse {

    Integer itemId;
    Participant participant;
    ParticipationType role;
    String title;

}

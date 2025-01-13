package ru.ichtus.gfc.backend.dto.eventItem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ichtus.gfc.backend.dto.confEvent.ConfEventResponse;
import ru.ichtus.gfc.backend.dto.participant.ParticipantResponse;
import ru.ichtus.gfc.backend.model.Participant;
import ru.ichtus.gfc.backend.model.dictionary.ParticipationType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventItemResponse {

    Integer item_id;
    ParticipantResponse participant;
    ParticipationType role;
    String title;
    ConfEventResponse event;
}

package ru.ichtus.gfc.backend.dto.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ichtus.gfc.backend.dto.participant.ItemResponse;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimetableItem {

    Instant itemStart;
    Instant itemEnd;
    List<ItemResponse> participants;
}

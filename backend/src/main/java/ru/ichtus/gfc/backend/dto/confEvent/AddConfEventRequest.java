package ru.ichtus.gfc.backend.dto.confEvent;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ichtus.gfc.backend.utils.NoUTCInstant;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddConfEventRequest {

    @JsonDeserialize(converter = NoUTCInstant.class)
    Instant eventStart;

    @JsonDeserialize(converter = NoUTCInstant.class)
    Instant eventEnd;

    String title;
    Integer roomId;
}

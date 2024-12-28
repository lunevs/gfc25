package ru.ichtus.gfc.backend.dto.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllTimetableResponse {

    Date eventStart;
    Date eventEnd;
    List<DayTimetableResponse> timetable;

}

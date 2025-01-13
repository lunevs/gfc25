package ru.ichtus.gfc.backend.dto.timetable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DayTimetableResponse {

    List<TimetableItem> items;
}

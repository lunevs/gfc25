package ru.ichtus.gfc.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ichtus.gfc.backend.model.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}

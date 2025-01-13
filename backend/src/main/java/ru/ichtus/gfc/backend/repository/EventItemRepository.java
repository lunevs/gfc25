package ru.ichtus.gfc.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ichtus.gfc.backend.model.EventItem;

public interface EventItemRepository extends JpaRepository<EventItem, Integer> {
}

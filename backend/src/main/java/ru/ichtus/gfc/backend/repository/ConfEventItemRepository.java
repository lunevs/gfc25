package ru.ichtus.gfc.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ichtus.gfc.backend.model.ConfEventItem;

public interface ConfEventItemRepository extends JpaRepository<ConfEventItem, Integer> {
}

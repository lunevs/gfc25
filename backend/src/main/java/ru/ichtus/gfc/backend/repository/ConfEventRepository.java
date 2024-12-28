package ru.ichtus.gfc.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ichtus.gfc.backend.model.ConfEvent;

public interface ConfEventRepository extends JpaRepository<ConfEvent, Integer> {
}

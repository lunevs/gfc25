package ru.ichtus.gfc.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ichtus.gfc.backend.exception.EntityNotFoundException;
import ru.ichtus.gfc.backend.model.Room;
import ru.ichtus.gfc.backend.repository.RoomRepository;
import ru.ichtus.gfc.backend.utils.BeanUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService implements DefaultService<Room> {

    private final RoomRepository roomRepository;


    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public Room findById(Integer id) {
        return roomRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Room not found!")
        );
    }

    @Override
    public Room save(Room item) {
        return roomRepository.save(item);
    }

    @Override
    public Room update(Room item) {
        Room existedRoom = findById(item.getId());
        BeanUtils.copyNotNullProperties(item, existedRoom);
        return roomRepository.save(existedRoom);
    }

    @Override
    public void deleteById(Integer id) {
        roomRepository.deleteById(id);
    }
}

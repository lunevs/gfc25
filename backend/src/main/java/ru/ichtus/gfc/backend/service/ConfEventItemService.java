package ru.ichtus.gfc.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ichtus.gfc.backend.exception.EntityNotFoundException;
import ru.ichtus.gfc.backend.model.ConfEventItem;
import ru.ichtus.gfc.backend.repository.ConfEventItemRepository;
import ru.ichtus.gfc.backend.utils.BeanUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConfEventItemService implements DefaultService<ConfEventItem>  {

    private final ConfEventItemRepository itemRepository;

    @Override
    public List<ConfEventItem> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public ConfEventItem findById(Integer id) {
        return itemRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Event item not found!")
        );
    }

    @Override
    public ConfEventItem save(ConfEventItem item) {
        return itemRepository.save(item);
    }

    @Override
    public ConfEventItem update(ConfEventItem item) {
        ConfEventItem existedItem = findById(item.getId());
        BeanUtils.copyNotNullProperties(item, existedItem);
        return itemRepository.save(existedItem);
    }

    @Override
    public void deleteById(Integer id) {
        itemRepository.deleteById(id);
    }
}

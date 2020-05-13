package com.paw.service;

import com.paw.entity.ArrayEntity;
import com.paw.entity.CardEntity;
import com.paw.entity.ListEntity;
import com.paw.repository.ArrayRepository;
import com.paw.repository.CardRepository;
import com.paw.repository.ListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ListRepository listRepository;
    private final ArrayRepository arrayRepository;
    private final CardRepository cardRepository;

    public ArrayEntity getArray(Long id) {
        return arrayRepository.findById(id).orElse(null);
    }

    public List<ArrayEntity> getArrays(){
        return arrayRepository.findAll();
    }

    public void createArray(String name) throws Exception{
        arrayRepository.save(new ArrayEntity(name));
    }

    public ArrayEntity updateArray(Long id, String name) {
        ArrayEntity table = arrayRepository.findById(id).orElse(null);
        if (table != null) {
            table.setName(name);
            return arrayRepository.save(table);
        }
        return null;
    }

    public ListEntity getListItem(Long id) {
        return listRepository.findById(id).orElse(null);
    }

    public void createListItem(Long arrayId, String name) throws Exception {
        ArrayEntity array = arrayRepository.findById(arrayId).orElse(null);
        if (array != null) {
            array.getLists().add(listRepository.save(new ListEntity(name)));
            arrayRepository.save(array);
        }
    }

    public ListEntity updateListItemName(Long id, String name) {
        ListEntity listItem = listRepository.findById(id).orElse(null);
        if (listItem != null) {
            listItem.setName(name);
            return listRepository.save(listItem);
        }
        return null;
    }

    public CardEntity getCard(Long id) {
        return cardRepository.findById(id).orElse(null);
    }

    public void createCard(Long listId, String name) throws Exception {
        ListEntity listItem = listRepository.findById(listId).orElse(null);
        if (listItem != null) {
            listItem.getCards().add(cardRepository.save(new CardEntity(name)));
            listRepository.save(listItem);
        }
    }

    public CardEntity updateCardName(Long id, String name) {
        CardEntity card = cardRepository.findById(id).orElse(null);
        if (card != null) {
            card.setName(name);
            return cardRepository.save(card);
        }
        return null;
    }
}

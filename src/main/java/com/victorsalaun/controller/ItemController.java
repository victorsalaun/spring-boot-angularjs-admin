package com.victorsalaun.controller;

import com.victorsalaun.domain.Item;
import com.victorsalaun.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Item addItem(@RequestBody Item item) {
        item.setId(null);
        return itemRepository.saveAndFlush(item);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Item updateItem(@RequestBody Item updatedItem, @PathVariable Integer id) {
        updatedItem.setId(id);
        return itemRepository.saveAndFlush(updatedItem);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable Integer id) {
        itemRepository.delete(id);
    }

}

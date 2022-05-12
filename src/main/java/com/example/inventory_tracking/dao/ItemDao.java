package com.example.inventory_tracking.dao;
import com.example.inventory_tracking.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemDao extends CrudRepository<Item, Long> {
}

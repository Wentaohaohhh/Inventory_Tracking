package com.example.inventory_tracking.dao;

import com.example.inventory_tracking.model.Warehouse;
import org.springframework.data.repository.CrudRepository;

public interface WarehouseDao extends CrudRepository<Warehouse, Long> {
}

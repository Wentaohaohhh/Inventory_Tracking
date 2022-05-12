package com.example.inventory_tracking.Service;

import com.example.inventory_tracking.dao.WarehouseDao;
import com.example.inventory_tracking.model.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseService {
    WarehouseDao warehouseDao;

    @Autowired
    public WarehouseService(WarehouseDao warehouseDao) {
        this.warehouseDao = warehouseDao;
    }
    public List<Warehouse> getAllWarehouse(){
        return (List<Warehouse>) warehouseDao.findAll();
    }
    public Warehouse addWarehouse(Warehouse warehouse){
        return warehouseDao.save(warehouse);
    }
}

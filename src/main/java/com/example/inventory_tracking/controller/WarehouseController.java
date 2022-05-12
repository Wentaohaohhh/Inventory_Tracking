package com.example.inventory_tracking.controller;

import com.example.inventory_tracking.Service.WarehouseService;
import com.example.inventory_tracking.model.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/warehouse")
public class WarehouseController {
    private WarehouseService warehouseService;
    @Autowired
    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GetMapping
    List<Warehouse> getAllWarehouse(){
        return warehouseService.getAllWarehouse();
    }

    @PostMapping
    @RequestMapping("/add")
    public ResponseEntity<String> addWarehouse(@RequestBody Warehouse warehouse){
        Warehouse savedWarehouse = warehouseService.addWarehouse(warehouse);
        return ResponseEntity.ok("Warehouse added, " + warehouse.toString());
    }
}

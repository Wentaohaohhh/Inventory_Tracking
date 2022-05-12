package com.example.inventory_tracking.controller;

import com.example.inventory_tracking.Exception.ItemEmptyNameException;
import com.example.inventory_tracking.Exception.NotExistException;
import com.example.inventory_tracking.Service.ItemService;
import com.example.inventory_tracking.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/item")
public class ItemController {
    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }
    @RequestMapping("/add")
    @PostMapping
    public ResponseEntity<String> addItem(@RequestBody Item item){
        try{
            Item savedItem = itemService.addItem(item);
            return ResponseEntity.ok("Item added, " + item.toString());
        }catch(ItemEmptyNameException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @PostMapping(path = "assigninventory/{iid}/{wid}")
    public  ResponseEntity<String> assignWarehouse(@PathVariable("iid") Long itemid,
                                                   @PathVariable("wid") Long warehouseid){
        try{
            Item updatedItem = itemService.assignWarehouse(itemid, warehouseid);
            return ResponseEntity.ok("Assigned warehouse, " + updatedItem.toString());
        }catch(NotExistException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    
}

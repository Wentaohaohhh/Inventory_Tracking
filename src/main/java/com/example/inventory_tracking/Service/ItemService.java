package com.example.inventory_tracking.Service;

import com.example.inventory_tracking.Exception.ItemEmptyException;
import com.example.inventory_tracking.Exception.NotExistException;
import com.example.inventory_tracking.dao.ItemDao;
import com.example.inventory_tracking.dao.WarehouseDao;
import com.example.inventory_tracking.model.Item;
import com.example.inventory_tracking.model.Warehouse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private ItemDao itemDao;
    private WarehouseDao warehouseDao;

    public ItemService(ItemDao itemDao, WarehouseDao warehouseDao) {
        this.itemDao = itemDao;
        this.warehouseDao = warehouseDao;
    }
    public Item addItem(Item item){
        if(item.getName().isEmpty()){
            throw new ItemEmptyException("Item name cannot be empty.");
        }
        return itemDao.save(item);
    }
    public Item updateItem(Item item){
        if(item.getId() == null || !itemDao.existsById(item.getId())){
            throw new NotExistException("Cannot find item id");
        }
        return itemDao.save(item);
    }
    public void deleteItem(Item item){
        if(item.getId() == null || !itemDao.existsById(item.getId())){
            throw new NotExistException("Cannot find item id");
        }
        itemDao.delete(item);
        //return item.getName() + " in " + item.getWarehouse() + " is deleted.";
    }
    public Item assignWarehouse(Long itemid, Long warehouseid){
        if(!itemDao.existsById(itemid)){
            throw new NotExistException("Cannot find item id " + itemid);
        }
        if(!warehouseDao.existsById(warehouseid)){
            throw new NotExistException("Cannot find warehouse id" + warehouseid);
        }
        Item item = getItemById(itemid).get();
        Warehouse warehouse = warehouseDao.findById(warehouseid).get();
        item.setWarehouse(warehouse);
        return itemDao.save(item);
    }
    public List<Item> getAllItems(){
        return (List<Item>) itemDao.findAll();
    }
    public Optional<Item> getItemById(Long id){
        return itemDao.findById(id);
    }
}

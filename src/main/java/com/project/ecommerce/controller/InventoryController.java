package com.project.ecommerce.controller;

import com.project.ecommerce.exception.ApiResponse;
import com.project.ecommerce.model.Dto.InventoryDto;
import com.project.ecommerce.service.contract.InventoryService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/inventories")
public class InventoryController {

    private InventoryService  inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<InventoryDto>> saveOrUpdate(@RequestBody InventoryDto inventoryDto){
        InventoryDto result = inventoryService.createOrUpdate(inventoryDto);
        return ResponseEntity.ok(ApiResponse.success(result,"new Inventory Added/updated successfully"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id){
        inventoryService.delete(id);
        return  ResponseEntity.ok(ApiResponse.success("Inventory deleted successfully"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryDto> getById(@PathVariable Integer id){
        InventoryDto result = inventoryService.getById(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<List<InventoryDto>> getAll(
            @RequestParam (defaultValue = "0") int page,
            @RequestParam  (defaultValue = "10")int saze
    ){
        Pageable pageable = PageRequest.of(page,saze);
        List<InventoryDto> result = inventoryService.getAllInventoriesByPage(pageable);
        return ResponseEntity.ok(result);
    }







}

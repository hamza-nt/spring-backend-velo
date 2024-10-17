package com.gestion.velo.controller;

import com.gestion.velo.dto.StoreDTO;
import com.gestion.velo.service.StoreService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/stores")
@AllArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @PostMapping
    public ResponseEntity<StoreDTO> addStore(@Valid @RequestBody StoreDTO storeDTO) {
        StoreDTO createdStore = storeService.addStore(storeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStore);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StoreDTO> updateStore(@PathVariable int id, @Valid @RequestBody StoreDTO storeDTO) {
        StoreDTO updatedStore = storeService.updateStore(id, storeDTO);
        return ResponseEntity.ok(updatedStore);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStore(@PathVariable int id) {
        storeService.deleteStore(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreDTO> getStoreById(@PathVariable int id) {
        StoreDTO store = storeService.getStoreById(id);
        return ResponseEntity.ok(store);
    }

    @GetMapping
    public ResponseEntity<List<StoreDTO>> getAllStores() {
        List<StoreDTO> stores = storeService.getAllStores();
        return ResponseEntity.ok(stores);
    }
}
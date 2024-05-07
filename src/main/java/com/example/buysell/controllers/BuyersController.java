package com.example.buysell.controllers;

import com.example.buysell.models.Buyers;
import com.example.buysell.services.BuyersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/buyers")
public class BuyersController {

    private final BuyersService buyersService;

    @GetMapping("/{id}")
    public ResponseEntity<Buyers> getBuyerById(@PathVariable Long id) {
        Buyers buyer = buyersService.getBuyersById(id);
        return ResponseEntity.ok(buyer);
    }

    @GetMapping
    public ResponseEntity<List<Buyers>> getAllBuyers() {
        List<Buyers> buyersList = buyersService.listBuyers();
        return ResponseEntity.ok(buyersList);
    }

    @PostMapping
    public ResponseEntity<Buyers> createBuyer(@RequestBody Buyers buyer) {
        Buyers createdBuyer = buyersService.saveBuyers(buyer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBuyer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuyer(@PathVariable Long id) {
        buyersService.deleteBuyer(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Buyers> updateBuyer(@RequestBody Buyers buyer, @PathVariable Long id) {
        Buyers updatedBuyer = buyersService.updateBuyer(buyer, id);
        return ResponseEntity.ok(updatedBuyer);
    }
}
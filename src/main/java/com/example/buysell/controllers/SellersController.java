package com.example.buysell.controllers;

import com.example.buysell.models.Sellers;
import com.example.buysell.services.SellersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sellers")
public class SellersController {
    private final SellersService sellersService;

    @GetMapping
    public ResponseEntity<List<Sellers>> getAllSellers() {
        List<Sellers> sellersList = sellersService.listSellers();
        return ResponseEntity.ok(sellersList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sellers> getSellerById(@PathVariable Long id) {
        Sellers seller = sellersService.getSellerById(id);
        return ResponseEntity.ok(seller);
    }

    @PostMapping
    public ResponseEntity<Sellers> createSeller(@RequestBody Sellers seller) {
        Sellers createdSeller = sellersService.saveSeller(seller);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSeller);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeller(@PathVariable Long id) {
        sellersService.deleteSeller(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sellers> updateSeller(@RequestBody Sellers seller, @PathVariable Long id) {
        Sellers updatedSeller = sellersService.updateSeller(seller, id);
        return ResponseEntity.ok(updatedSeller);
    }
}

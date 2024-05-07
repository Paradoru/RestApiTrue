package com.example.buysell.controllers;

import com.example.buysell.models.Sales;
import com.example.buysell.services.SalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sales")
public class SalesController {
    private final SalesService salesService;

    @GetMapping
    public ResponseEntity<List<Sales>> getAllSales() {
        List<Sales> salesList = salesService.listSales();
        return ResponseEntity.ok(salesList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sales> getSalesById(@PathVariable Long id) {
        Sales sales = salesService.getSalesById(id);
        return ResponseEntity.ok(sales);
    }

    @PostMapping
    public ResponseEntity<Sales> createSales(@RequestBody Sales sales) {
        Sales createdSales = salesService.saveSales(sales);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSales);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSales(@PathVariable Long id) {
        salesService.deleteSales(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sales> updateSales(@RequestBody Sales sales, @PathVariable Long id) {
        Sales updatedSales = salesService.UpdateSales(sales, id);
        return ResponseEntity.ok(updatedSales);
    }
}

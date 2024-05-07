package com.example.buysell.services;

import com.example.buysell.models.Sales;
import com.example.buysell.repository.SalesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalesService {
    private final SalesRepository salesRepository;

    public List<Sales> listSales() {
        return salesRepository.findAll();
    }

    public Sales getSalesById(Long id) {
        return salesRepository.findById(id).orElse(null);
    }

    public Sales saveSales(Sales sales) {
        salesRepository.save(sales);
        return sales;
    }

    public Sales deleteSales(Long id) {
        Sales sales = salesRepository.findById(id).orElse(null);
        if (sales != null) {
            salesRepository.deleteById(id);
            return sales;
        }
        return null;
    }

    public Sales UpdateSales(Sales salesData, Long id) {
        Sales sales = salesRepository.findById(id).orElse(null);
        if (sales != null) {
            sales.setDate_sell(salesData.getDate_sell());
            sales.setProduct(salesData.getProduct());
            sales.setBuyers_id(salesData.getBuyers_id());
            sales.setSellers_id(salesData.getSellers_id());
            sales.setQuantity_sell(salesData.getQuantity_sell());
            sales.setPrice(salesData.getPrice());

            salesRepository.save(sales);
            return sales;
        }
        return null;
    }
    public void deleteAllSales() {
        salesRepository.deleteAll();
    }
}

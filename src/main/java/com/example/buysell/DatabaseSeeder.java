package com.example.buysell;

import com.example.buysell.models.Buyers;
import com.example.buysell.models.Product;
import com.example.buysell.models.Sales;
import com.example.buysell.models.Sellers;
import com.example.buysell.services.BuyersService;
import com.example.buysell.services.ProductService;
import com.example.buysell.services.SalesService;
import com.example.buysell.services.SellersService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final BuyersService buyersService;
    private final ProductService productService;
    private final SalesService salesService;
    private final SellersService sellersService;

    public DatabaseSeeder(BuyersService buyersService, ProductService productService, SalesService salesService, SellersService sellersService) {
        this.buyersService = buyersService;
        this.productService = productService;
        this.salesService = salesService;
        this.sellersService = sellersService;
    }

    @Override
    public void run(String... args) throws Exception {
        buyersService.deleteAllBuyers();
        productService.deleteAllProducts();
        salesService.deleteAllSales();
        sellersService.deleteAllSellers();

        // Создание и сохранение тестовых покупателей
        Buyers buyer1 = new Buyers(null, "Иван", "Иванов", "+7123456789", "ivan@example.com");
        Buyers buyer2 = new Buyers(null, "Петр", "Петров", "+7987654321", "petr@example.com");
        Buyers buyer3 = new Buyers(null, "Мария", "Сидорова", "+7456789012", "maria@example.com");
        buyersService.saveBuyers(buyer1);
        buyersService.saveBuyers(buyer2);
        buyersService.saveBuyers(buyer3);

        // Создание и сохранение тестовых продуктов
        Product product1 = new Product(null, "Продукт 1", "Холодильник", 100, 5);
        Product product2 = new Product(null, "Продукт 2", "Телевизор", 1000, 6);
        Product product3 = new Product(null, "Продукт 3", "Телефон", 33, 123);
        productService.saveProduct(product1);
        productService.saveProduct(product2);
        productService.saveProduct(product3);

        // Создание и сохранение тестовых продаж
        Sales sale1 = new Sales(null, LocalDateTime.now(),1L, 1L, 1L, 12, 2.99);
        Sales sale2 = new Sales(null, LocalDateTime.now().minusDays(2), 2L, 2L, 1L, 50, 3.50);
        Sales sale3 = new Sales(null, LocalDateTime.now().minusWeeks(1), 3L, 3L, 1L, 2, 500.90);
        salesService.saveSales(sale1);
        salesService.saveSales(sale2);
        salesService.saveSales(sale3);

        // Создание и сохранение тестовых продавцов
        Sellers seller1 = new Sellers(null, "Продавец", "Никита", 81234567, "seller1@example.com");
        Sellers seller2 = new Sellers(null, "Продавец", "Олег", 8876543, "seller2@example.com");
        Sellers seller3 = new Sellers(null, "Продавец", "Дарья", 84567890, "seller3@example.com");
        sellersService.saveSeller(seller1);
        sellersService.saveSeller(seller2);
        sellersService.saveSeller(seller3);
    }
}
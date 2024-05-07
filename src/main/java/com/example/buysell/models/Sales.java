package com.example.buysell.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "sales")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "date_sell")
    private LocalDateTime date_sell;
    @JoinColumn(name = "products_id")
    private Long product;
    @JoinColumn(name = "buyers_id")
    private Long buyers_id;
    @JoinColumn(name = "sellers_id")
    private Long sellers_id;
    @Column(name = "quantity_sell")
    private int quantity_sell;
    @Column(name = "price")
    private double price;
}

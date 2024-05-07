package com.example.buysell.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "sellers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sellers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sellers_id")
    private Long id;
    @Column(name = "First_name")
    private String first_name;
    @Column(name = "Last_name")
    private String last_name;
    @Column(name = "phone_number")
    private int phone_number;
    @Column(name = "email")
    private String email;
}

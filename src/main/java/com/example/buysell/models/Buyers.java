package com.example.buysell.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "buyers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Buyers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "buyers_id")
    private Long id;
    @Column(name = "First_name")
    private String first_name;
    @Column(name = "Last_name")
    private String last_name;
    @Column(name = "phone_number")
    private String phone_number;
    @Column(name = "email")
    private String email;
}

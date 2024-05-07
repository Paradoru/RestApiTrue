package com.example.buysell.repository;

import com.example.buysell.models.Sellers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SellersRepository extends JpaRepository<Sellers,Long>
{
}

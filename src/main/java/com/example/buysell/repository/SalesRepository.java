package com.example.buysell.repository;

import com.example.buysell.models.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalesRepository extends JpaRepository<Sales,Long>
{
}

package com.example.buysell.repository;

import com.example.buysell.models.Buyers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuyersRepository extends JpaRepository<Buyers,Long>
{
}
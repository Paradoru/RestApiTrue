package com.example.buysell.services;

import com.example.buysell.models.Sellers;
import com.example.buysell.repository.SellersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SellersService {
    private final SellersRepository sellersRepository;

    public List<Sellers> listSellers() {
        return sellersRepository.findAll();
    }

    public Sellers getSellerById(Long id) {
        return sellersRepository.findById(id).orElse(null);
    }

    public Sellers saveSeller(Sellers seller) {
        sellersRepository.save(seller);
        return seller;
    }

    public Sellers deleteSeller(Long id) {
        Sellers seller = sellersRepository.findById(id).orElse(null);
        if (seller != null) {
            sellersRepository.deleteById(id);
            return seller;
        }
        return null;
    }

    public Sellers updateSeller(Sellers sellerData, Long id) {
        Sellers seller = sellersRepository.findById(id).orElse(null);
        if (seller != null) {
            seller.setFirst_name(sellerData.getFirst_name());
            seller.setLast_name(sellerData.getLast_name());
            seller.setPhone_number(sellerData.getPhone_number());
            seller.setEmail(sellerData.getEmail());

            sellersRepository.save(seller);
            return seller;
        }
        return null;
    }
    public void deleteAllSellers() {
        sellersRepository.deleteAll();
    }
}

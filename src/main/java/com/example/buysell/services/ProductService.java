package com.example.buysell.services;
import com.example.buysell.models.Product;
import com.example.buysell.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public List<Product> listProducts() {
        return productRepository.findAll();
    }
    public Product getProductById(Long id){
        return productRepository.findById(id).orElse(null);
    }
    public Product saveProduct(Product product){
        productRepository.save(product);
        return product;
    }
    public Product deleteProduct(Long id){
        Product product = productRepository.findById(id).orElse(null);
        if(product!=null){
            productRepository.deleteById(id);
            return product;
        }
        return null;
    }
    public Product UpdateProduct(Product productData, Long id){
        Product product = productRepository.findById(id).orElse(null);
        if (product!=null){
            product.setQuantity(productData.getQuantity());
            product.setTitle(productData.getTitle());
            product.setDescription(productData.getDescription());
            product.setPrice(productData.getPrice());
            productRepository.save(product);
            return product;
        }
        return null;
    }
    public void deleteAllProducts() {
        productRepository.deleteAll();
    }
}

package edu.mum.service;

import edu.mum.entity.Product;
import edu.mum.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    //create
    public void saveProduct(Product product) {

        productRepository.save(product);
    }

    //delete
    public void deleteProduct(int productId) {

        productRepository.delete(productId);
    }

    //read
    public List<Product> getAllProduct() {

        List<Product> products = productRepository.findAll();

        return products;

    }

    public Product getProduct(Integer productId) {
        return productRepository.findOne(productId);
    }

    //update
    public void updateProduct(int productId, Product product) {
        productRepository.save(product);
    }


}

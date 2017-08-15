package edu.mum.service;

import edu.mum.entity.Product;
import edu.mum.entity.ProductType;
import edu.mum.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class ProductService  {

    @Autowired
    private ProductRepository productRepository;

    public String saveProduct(Product product){

        productRepository.save(product);


        return "saved!";
    }

    public String deleteProduct(int productId){

        productRepository.delete(productId);

        return " item is deleted";
    }

    public List<Product> searchAllProduct(){

        List<Product>products = productRepository.findAll();

        return products;

    }

    public Product getProduct(Integer productId) {
        return  productRepository.findOne(productId);
    }

    public String updateProduct(Product product){

        productRepository.save(product);

        return "successfully updated!";
    }



}

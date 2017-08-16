package edu.mum.repository;

import edu.mum.entity.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product,Integer> {

    List<Product> findByDescription(String description);
    List<Product> findByProductName(String productname);
    /*Product findByProductName(String productname);*/

    /* List<Product> findByProductType(ProductType type);*/
    List<Product> findByPrice(double price, Sort sort);

}

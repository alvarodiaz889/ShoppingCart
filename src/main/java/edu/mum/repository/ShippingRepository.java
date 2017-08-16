package edu.mum.repository;

import edu.mum.entity.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Sushan on 8/15/2017.
 */
public interface ShippingRepository extends JpaRepository<Shipping, Integer> {
}

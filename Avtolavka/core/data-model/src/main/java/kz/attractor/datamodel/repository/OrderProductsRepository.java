package kz.attractor.datamodel.repository;

import kz.attractor.datamodel.model.OrderProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderProductsRepository extends JpaRepository<OrderProducts, Long> {
    List<OrderProducts> findAllByOrderId(Long id);
}

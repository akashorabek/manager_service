package kz.attractor.datamodel.repository;

import kz.attractor.datamodel.model.ProductName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductNameRepository extends JpaRepository<ProductName, Long> {
}

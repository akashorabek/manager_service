package kz.attractor.datamodel.repository;

import kz.attractor.datamodel.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {
    List<Product> findAllByWarehouse_IncludeToPriceList(boolean b);
    Page<Product> findAll(Pageable pageable);
    Page<Product> findAll(Specification<Product> specification, Pageable pageable);
}

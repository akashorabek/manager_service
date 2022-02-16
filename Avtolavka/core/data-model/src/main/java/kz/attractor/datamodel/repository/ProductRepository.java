package kz.attractor.datamodel.repository;

import kz.attractor.datamodel.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer> {
//    @Query(
//            "select p from Product as p where (lower(p.name) like CONCAT('%' || lower(:name) || '%')"
//    )
//    Iterable<Product> findAllByName(String name);
}

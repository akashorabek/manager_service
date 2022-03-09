package kz.attractor.datamodel.repository;

import kz.attractor.datamodel.model.Client;
import kz.attractor.datamodel.model.Contact;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findAllByClient_Id(long id);
    List<Contact> findAll(Specification<Contact> specification);
}

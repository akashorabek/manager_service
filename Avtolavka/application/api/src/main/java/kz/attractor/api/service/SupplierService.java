package kz.attractor.api.service;

import kz.attractor.api.dto.SupplierDto;
import kz.attractor.datamodel.model.Supplier;
import kz.attractor.datamodel.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SupplierService {
    private final SupplierRepository repository;

    public List<SupplierDto> findAll() {
        List<Supplier> suppliers = repository.findAll();
        return suppliers.stream()
                .map(SupplierDto::from)
                .collect(Collectors.toList());
    }

    public String create(String name, String email, String partner, String shipment){
        var supplier = Supplier.builder()
                .name(name)
                .email(email)
                .partnerName(partner)
                .shipment(shipment)
                .build();

        repository.save(supplier);

        return "redirect:/suppliers";
    }


}

package kz.attractor.api.dto;

import kz.attractor.datamodel.model.Supplier;
import lombok.Builder;

@Builder
public class SupplierDto {
    private Long id;
    private String name;
    private String partnerName;
    private String email;
    private String shipment;

    public static SupplierDto from(Supplier supplier){
        return SupplierDto.builder()
                .id(supplier.getId())
                .name(supplier.getName())
                .partnerName(supplier.getPartnerName())
                .email(supplier.getEmail())
                .shipment(supplier.getShipment())
                .build();
    }
}

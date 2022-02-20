package kz.attractor.api.dto;

import kz.attractor.datamodel.model.Order;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OrderDto {
    private long id;
    private String dateCreation;
    private String client;

    public static OrderDto from(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .dateCreation(order.getDateCreation().toString())
                .client(order.getClient().getName())
                .build();
    }
}

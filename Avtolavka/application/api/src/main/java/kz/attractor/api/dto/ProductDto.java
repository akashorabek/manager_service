package kz.attractor.api.dto;

import kz.attractor.api.config.Param;
import kz.attractor.datamodel.model.Product;
import kz.attractor.datamodel.model.Warehouse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class ProductDto {
    private int id;
    private String name;
    private int quantity;
    private long price;
    private boolean inStock;
    private String warehouse;

    public static ProductDto from(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .quantity(product.getQuantity())
                .price(Math.round(product.getPurchasePrice()
                        .multiply(BigDecimal.valueOf(1 + Param.RATE_FIRST))
                        .multiply(BigDecimal.valueOf(1 + Param.RATE_SECOND))
                        .doubleValue()))
                .inStock(product.isInStock())
                .warehouse(product.getWarehouse().getName())
                .build();
    }
}

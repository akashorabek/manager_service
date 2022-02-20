package kz.attractor.datamodel.model;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "orders_products")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private Integer quantity;
}

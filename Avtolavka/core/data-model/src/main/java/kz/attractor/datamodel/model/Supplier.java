package kz.attractor.datamodel.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "partner")
    private String partnerName;
    @Column(name = "email")
    private String email;
    @Column(name = "shipment")
    private String shipment;
}

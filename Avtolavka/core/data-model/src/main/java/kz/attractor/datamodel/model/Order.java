package kz.attractor.datamodel.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_create")
    private LocalDateTime dateCreation;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @Column(name = "is_closed")
    private boolean isClosed;
}

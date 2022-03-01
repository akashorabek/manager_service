package kz.attractor.datamodel.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "contacts")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone1")
    private String phone1;

    @Column(name = "phone2")
    private String phone2;

    @Column(name = "phone3")
    private String phone3;

    @Column(name = "email1")
    private String email1;

    @Column(name = "email2")
    private String email2;

    @Column(name = "email3")
    private String email3;

    @Column(name = "status")
    private ContactStatus status;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
package kz.attractor.datamodel.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "clients")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_main")
    private String phoneMain;

    @Column(name = "phone_1")
    private String phone1;

    @Column(name = "phone_2")
    private String phone2;

    @Column(name = "phone_3")
    private String phone3;

    @Column(name = "email_main")
    private String emailMain;

    @Column(name = "email_1")
    private String email1;

    @Column(name = "email_2")
    private String email2;

    @Column(name = "email_3")
    private String email3;

    @Column(name = "status")
    private ClientStatus status;

    @Column(name = "bank")
    private ClientBank bank;
}
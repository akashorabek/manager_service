package kz.attractor.datamodel.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tasks")
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "createDate")
    private LocalDate createDate;

    @Column(name = "deadline")
    private LocalDate deadline;

    @Column(name = "finish")
    private LocalDate finish;

    @Column(name = "status")
    private TaskStatus status;

}

package kz.attractor.datamodel.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "create")
    private LocalDate create;

    @Column(name = "deadline")
    private LocalDate deadline;

    @Column(name = "finish")
    private LocalDate finish;

    @Column(name = "status")
    private TaskStatus status;

}

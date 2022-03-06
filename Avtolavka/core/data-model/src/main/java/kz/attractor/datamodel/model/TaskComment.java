package kz.attractor.datamodel.model;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "task_comments")
@Builder
public class TaskComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "createDate")
    private String createDate;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
}

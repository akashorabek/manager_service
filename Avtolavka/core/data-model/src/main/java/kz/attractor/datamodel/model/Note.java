package kz.attractor.datamodel.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Note {
    public String description;
    public LocalDateTime createdDate;
}

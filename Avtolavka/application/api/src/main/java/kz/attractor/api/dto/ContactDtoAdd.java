package kz.attractor.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ContactDtoAdd {
    private String name;
    private String phone;
    private String email;
    private String status;
    private long clientId;
}

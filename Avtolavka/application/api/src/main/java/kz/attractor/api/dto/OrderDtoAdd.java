package kz.attractor.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDtoAdd {
    private long contactId;
    private List<Integer> productIds;
    private List<Integer> quantities;
}

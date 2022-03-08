package kz.attractor.api.controller.apiController;

import kz.attractor.api.service.BankService;
import kz.attractor.datamodel.model.ClientBank;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/banks")
public class BankApiController {
    private final BankService bankService;

    @GetMapping()
    public List<String> getBanks() {
        return bankService.getBanks();
    }
}

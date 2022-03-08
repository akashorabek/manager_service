package kz.attractor.api.service;

import kz.attractor.datamodel.model.ClientBank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankService {
    public List<String> getBanks() {
        var banks = ClientBank.getNamesOfBanks();
        return banks;
    }
}

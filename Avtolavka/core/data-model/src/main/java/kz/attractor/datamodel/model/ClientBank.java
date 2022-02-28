package kz.attractor.datamodel.model;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum ClientBank {
    ALTYN_BANK("АО Altyn Bank", "050008, г. Алматы, пр. Абая, 109 ", "ATYNKZKA", "KZ97125KZT1001300327", "980740000057"),
    BANK_RBK("Bank RBK", "050012, г. Алматы, ул. Ади Шарипова, 84", "KINCKZKA", "KZ57125KZT1002300244", "920440001102"),
    FIRST_HEARTLAND_JýSAN_BANK("First Heartland Jýsan Bank", "050013, г. Алматы, пр. Аль-Фараби, дом 15, блок 4В","TSES KZ KA", "KZ48125KZT1001300336", "920140000084"),
    FORTEBANK("ForteBank", "050004, г.Алматы, ул.Фурманова, 50", "IRTYKZKA", "KZ23125KZT1001300204", "990740000683"),
    KASPI_BANK("Kaspi Bank", "050013, г. Алматы, ул. Наурызбай батыра,154а", "CASPKZKA", "KZ67722S000000004165", "060240016519"),
    CENTERCREDIT("Банк ЦентрКредит", "050059, г. Алматы, пр. Аль-Фараби, 38", "KCJBKZKX", "30111398500000000277", "980640000093"),
    ALFA_BANK("ДБ \"Альфа-Банк\"", "050012, г.Алматы ул.Масанчи, 57а", "ALFAKZKA", "KZ71125KZT1001300213", "941240000341"),
    HOME_CREDIT_BANK("ДБ АО \"Банк Хоум Кредит\"", "050059, г. Алматы , ул. Фурманова 248", "INLMKZKA", "KZ43125KZT1001300329", "930540000147"),
    SBERBANK("ДБ АО «Сбербанк России»", "050059, г.Алматы пр. Аль-Фараби, 13/1", "SABRKZKA", "KZ82125KZT1001300306", "930740000137"),
    HALYK_BANK("Народный сберегательный банк Казахстана", "050059, г.Алматы, пр. Аль-Фараби, 40", "HSBKKZKX", "KZ87125KZT1001300313", "940140000385"),
    NUR_BANK("АО Нурбанк", "050010, г. Алматы, пр. Абая, 10В", "NURSKZKX", "KZ61125KZT1001300296", "930940000164");

    public final String bankName;
    public final String bankAddress;
    public final String bankBik;
    public final String accountNumber;
    public final String bankBin;

    private static final Map<String, ClientBank> BY_BANK = new HashMap<>();

    static {
        for(ClientBank clientBank: values()) {
            BY_BANK.put(clientBank.bankName, clientBank);
            BY_BANK.put(clientBank.bankAddress, clientBank);
            BY_BANK.put(clientBank.bankBik, clientBank);
            BY_BANK.put(clientBank.accountNumber, clientBank);
            BY_BANK.put(clientBank.bankBin, clientBank);
        }
    }
    private ClientBank(String bankName, String bankAddress, String bankBIK, String accountNumber, String bankBin) {
        this.bankName = bankName;
        this.bankAddress = bankAddress;
        this.bankBik = bankBIK;
        this.accountNumber = accountNumber;
        this.bankBin = bankBin;
    }

    public static ClientBank valueOfBankName(String bankName) {
        return BY_BANK.get(bankName);
    }
}

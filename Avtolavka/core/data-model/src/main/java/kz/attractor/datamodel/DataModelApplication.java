package kz.attractor.datamodel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "kz.attractor")
public class DataModelApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataModelApplication.class, args);
    }

}

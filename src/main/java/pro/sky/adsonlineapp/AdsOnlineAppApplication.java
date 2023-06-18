package pro.sky.adsonlineapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@EnableAutoConfiguration
@SpringBootApplication
//@ComponentScan({"pro.sky.adsonlineapp.repository", "pro.sky.adsonlineapp.configuration"})
public class AdsOnlineAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdsOnlineAppApplication.class, args);
    }

}

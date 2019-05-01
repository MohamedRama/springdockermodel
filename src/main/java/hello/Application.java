package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    @RequestMapping("/")
    public String home() {
        return "XHello Docker World Spyre & Mo Awesome app but with models";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

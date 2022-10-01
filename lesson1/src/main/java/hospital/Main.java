package hospital;

import hospital.entities.AppConfig;
import hospital.entities.Client;
import hospital.entities.Refferals.Refferal;
import hospital.entities.Refferals.Registry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Registry registry = context.getBean("registry", Registry.class);

        Client client = new Client("Вася", "stomatologist", 1001);
        registry.direct(client);
        registry.issue_direction();

        Client client2 = new Client("Петр", "therapist", 1002);
        registry.direct(client2);
        registry.issue_direction();

    }
}

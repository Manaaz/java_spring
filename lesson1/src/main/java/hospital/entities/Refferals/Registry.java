package hospital.entities.Refferals;

import hospital.entities.AppConfig;
import hospital.entities.Client;
import hospital.entities.Refferals.Refferal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("registry")
@Scope("prototype")
public class Registry implements Refferal {
    // @Autowired
    Client client;
    private Refferal refferal;
    private ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    public Refferal getRefferal() {
        return refferal;
    }

    @Autowired(required = false)
    @Qualifier("Refferal")
    public void setRefferal(Refferal refferal) {
        this.refferal = refferal;
    }

    @Override
    public void direct(Client client) {

        this.client = client;

        System.out.println("Вход в регистратуру: " + client.getName());

        setRefferal(context.getBean("archive", Refferal.class));
        refferal.direct(client);

    }

    public void direct() {

    }

    public void issue_direction() {

        if(refferal == null){
            System.out.println("Не удалось получить направление.");
            return ;
        }

        setRefferal(context.getBean(client.getDoctor(), Refferal.class));
        refferal.direct();
    }
}


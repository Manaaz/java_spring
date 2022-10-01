package hospital.entities.Refferals;
import hospital.entities.Client;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("stomatologist")
@Scope("prototype")
public class Refferal_Stomatologist implements Refferal, Doctor {

    private int cabinet = 101;

    @Override
    public void direct(Client client) {
        System.out.println("Выдано направление к стоматологу. " + client.getName() + ", "  + getCabinet());
    }

    public void direct() {
        System.out.println("Выдано направление к стоматологу. " + getCabinet());
    }
    public String getCabinet(){
        return "Кабинет: " + cabinet;
    }

}
package hospital.entities.Refferals;
import hospital.entities.Client;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("therapist")
@Scope("prototype")
public class Refferal_Therapist implements Refferal, Doctor {

    private int cabinet = 202;

    @Override
    public void direct(Client client) {
        System.out.println("Выдано направление к терапевту. " + client.getName() + ", " + getCabinet());
    }

    public void direct() {
        System.out.println("Выдано направление к терапевту. " + getCabinet());
    }
    public String getCabinet(){
        return "Кабинет: " + cabinet;
    }

}
package hospital.entities.Refferals;
import hospital.entities.Client;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("archive")
@Scope("prototype")
public class Archive implements Refferal{

    private int archiveNumber;

    public void direct(Client client) {
        setArchiveNumber(client.getArchiveFileNumber());
        System.out.println("Получено дело из архива " + archiveNumber);
    }

    @Override
    public void direct() {

    }

    private void setArchiveNumber(int archiveNumber){
        this.archiveNumber = archiveNumber;
    }

}

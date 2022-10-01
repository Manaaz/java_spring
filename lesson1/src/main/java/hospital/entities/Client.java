package hospital.entities;

public class Client {
    private String name;
    private int archiveFileNumber;
    private String doctor;

    public Client(String name, String doctor, int archiveFileNumber) {
        this.name = name;
        this.archiveFileNumber = archiveFileNumber;
        this.doctor = doctor;
    }

    public String getName() {
        return name;
    }

    public int getArchiveFileNumber() {
        return archiveFileNumber;
    }

    public String getDoctor() {
        return doctor;
    }
}

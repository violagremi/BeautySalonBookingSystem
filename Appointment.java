package BeautyAndWellnessAppointmentScheduler;

public class Appointment {
    private String appointmentId;
    private Client client;
    private Provider provider;
    private Service service;
    private String appointmentDate;
    private String appointmentTime;
    private boolean isDone;

    public Appointment(String appointmentId, Client client, Provider provider, Service service, String appointmentDate, String appointmentTime, boolean isDone) {
        this.appointmentId = appointmentId;
        this.client = client;
        this.provider = provider;
        this.service = service;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.isDone = isDone;
    }

    public Appointment() {
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId='" + appointmentId + '\'' +
                ", client=" + client +
                ", provider=" + provider +
                ", service=" + service +
                ", appointmentDate='" + appointmentDate + '\'' +
                ", appointmentTime='" + appointmentTime + '\'' +
                ", isDone=" + isDone +
                '}';
    }
}

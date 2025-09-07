package BeautyAndWellnessAppointmentScheduler;

public class Client {
    private String clientId;
    private String clientName;
    private String clientNumber;
    private String clientEmail;
    private String preferredService;

    public Client(String clientId, String clientName, String clientNumber, String clientEmail, String preferredService) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientNumber = clientNumber;
        this.clientEmail = clientEmail;
        this.preferredService = preferredService;
    }

    public Client() {
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(String clientNumber) {
        this.clientNumber = clientNumber;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getPreferredService() {
        return preferredService;
    }

    public void setPreferredService(String preferredService) {
        this.preferredService = preferredService;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId='" + clientId + '\'' +
                ", clientName='" + clientName + '\'' +
                ", clientNumber='" + clientNumber + '\'' +
                ", clientEmail='" + clientEmail + '\'' +
                ", preferredService='" + preferredService + '\'' +
                '}';
    }
}


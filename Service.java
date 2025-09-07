package BeautyAndWellnessAppointmentScheduler;

public class Service {
    private String serviceId;
    private String name;
    private double price;
    private int durationInMinutes;

    public Service(String serviceId, String name, double price, int durationInMinutes) {
        this.serviceId = serviceId;
        this.name = name;
        this.price = price;
        this.durationInMinutes = durationInMinutes;
    }

    public Service(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    @Override
    public String toString() {
        return "Service{" +
                "serviceId='" + serviceId + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", durationInMinutes=" + durationInMinutes +
                '}';
    }
}

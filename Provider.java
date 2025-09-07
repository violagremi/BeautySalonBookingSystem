package BeautyAndWellnessAppointmentScheduler;

public class Provider {
    private String providerId;
    private String serviceProviderName;
    private String typeOfService;
    private boolean isAvailable;
    private int yearsOfExperience;
    private double rating;
    private int workingHours;


    public Provider(String providerId, String serviceProviderName, String typeOfService, boolean isAvailable, int yearsOfExperience, double rating, int workingHours) {
        this.providerId = providerId;
        this.serviceProviderName = serviceProviderName;
        this.typeOfService = typeOfService;
        this.isAvailable = isAvailable;
        this.yearsOfExperience = yearsOfExperience;
        this.rating = rating;
        this.workingHours = workingHours;
    }

    public Provider(){

    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getServiceProviderName() {
        return serviceProviderName;
    }

    public void setServiceProviderName(String serviceProviderName) {
        this.serviceProviderName = serviceProviderName;
    }

    public String getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(String typeOfService) {
        this.typeOfService = typeOfService;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "providerId='" + providerId + '\'' +
                ", serviceProviderName='" + serviceProviderName + '\'' +
                ", typeOfService='" + typeOfService + '\'' +
                ", isAvailable=" + isAvailable +
                ", yearsOfExperience=" + yearsOfExperience +
                ", rating=" + rating +
                ", workingHours=" + workingHours +
                '}';
    }
}

package BeautyAndWellnessAppointmentScheduler;

import BeautyAndWellnessAppointmentScheduler.Repository.AppointmentRepository;
import BeautyAndWellnessAppointmentScheduler.Repository.ClientRepository;
import BeautyAndWellnessAppointmentScheduler.Repository.ProviderRepository;
import BeautyAndWellnessAppointmentScheduler.Repository.ServiceRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ClientRepository clientRepository = new ClientRepository();
        ProviderRepository providerRepository = new ProviderRepository();
        ServiceRepository serviceRepository = new ServiceRepository();
        AppointmentRepository appointmentRepository = new AppointmentRepository(clientRepository,
                providerRepository, serviceRepository);

        clientRepository.loadFromFile();
        providerRepository.loadFromFile();
        serviceRepository.loadFromFile();
        appointmentRepository.loadFromFile();

        boolean running = true;

        while(running){
            System.out.println("\n  BEAUTY & WELLNESS APPOINTMENT SCHEDULER ");
            System.out.println("1.Add Client");
            System.out.println("2.View All Clients");
            System.out.println("3.Add Provider");
            System.out.println("4.View All Providers");
            System.out.println("5.Add Service");
            System.out.println("6.View All Services");
            System.out.println("7.Add Appointment");
            System.out.println("8.View All Appointments");
            System.out.println("0. Exit");
            System.out.println("Choose an option:  ");

            String choice = scanner.nextLine();

            switch(choice){
                case "1":
                    System.out.println("Enter client ID: ");
                    String clientId = scanner.nextLine();
                    System.out.println("Enter client name: ");
                    String clientName = scanner.nextLine();
                    System.out.println("Enter client phone number: ");
                    String clientNumber = scanner.nextLine();
                    System.out.println("Enter client email: ");
                    String clientEmail = scanner.nextLine();
                    System.out.println("Enter client preferred service: ");
                    String preferredService = scanner.nextLine();

                    Client client = new Client(clientId, clientName, clientNumber,
                            clientEmail, preferredService);
                    clientRepository.addClient(client);
                    System.out.println("Client Added!");
                    break;
                case "2":
                    for(Client c: clientRepository.getAllClients()){
                        System.out.println(c);
                    }
                    break;
                case "3":
                    System.out.println("Enter provider ID: ");
                    String providerId = scanner.nextLine();
                    System.out.println("Enter provider name: ");
                    String serviceProviderName = scanner.nextLine();
                    System.out.println("Enter provider type of service: ");
                    String typeOfService = scanner.nextLine();
                    System.out.println("Is available (true/false)");
                    boolean isAvailable = Boolean.parseBoolean(scanner.nextLine());
                    System.out.println("Years of experience: ");
                    int yearsOfExperience = Integer.parseInt(scanner.nextLine());
                    System.out.println("Rating: ");
                    double rating = Double.parseDouble(scanner.nextLine());
                    System.out.println("Working hours: ");
                    int workingHours = Integer.parseInt(scanner.nextLine());

                    Provider provider = new Provider(providerId, serviceProviderName,
                            typeOfService,isAvailable, yearsOfExperience, rating, workingHours);
                    providerRepository.addProvider(provider);
                    System.out.println("Provider Added!");
                    break;
                case "4":
                    for(Provider p: providerRepository.getAllProviders()){
                        System.out.println(p);
                    }
                    break;
                case "5":
                    System.out.println("Enter service ID:");
                    String serviceId = scanner.nextLine();
                    System.out.println("Enter service name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter price: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    System.out.println("Enter duration in minutes: ");
                    int durationInMinutes = Integer.parseInt(scanner.nextLine());

                    Service service = new Service(serviceId, name, price, durationInMinutes);
                    serviceRepository.addService(service);
                    System.out.println("Service Added!");
                    break;
                case "6":
                    for(Service s: serviceRepository.getAllServices()){
                        System.out.println(s);
                    }
                    break;
                case "7":
                    System.out.println("Enter appointment ID: ");
                    String appointmentId = scanner.nextLine();

                    System.out.println("Enter Client: ");
                    String aClientId = scanner.nextLine();
                    Client aClient = clientRepository.getClientById(aClientId);

                    System.out.println("Enter Provider: ");
                    String aProviderId = scanner.nextLine();
                    Provider aProvider = providerRepository.getProviderById(aProviderId);

                    System.out.println("Enter Service: ");
                    String aServiceId = scanner.nextLine();
                    Service aService = serviceRepository.getServiceById(aServiceId);

                    System.out.println("Enter appointment date (yyyy-mm-dd): ");
                    String date = scanner.nextLine();
                    System.out.println("Enter appointment time (HH:mm): ");
                    String time = scanner.nextLine();
                    System.out.println("Enter (true/false) if it is done or not");
                    boolean isDone = Boolean.parseBoolean(scanner.nextLine());

                    if(aClient != null && aProvider != null && aService != null){
                        Appointment appointment = new Appointment(appointmentId, aClient, aProvider,
                                aService, date, time, isDone);
                        appointmentRepository.addAppointment(appointment);
                        System.out.println("Appointment Added!");
                    }else{
                        System.out.println("Invalid Client, Provider, or Service ID!");
                    }
                    break;
                case "8":
                    for(Appointment a: appointmentRepository.getAllAppointments()){
                        System.out.println(a);
                    }
                    break;
                case"0":
                    System.out.println("Goodbye");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Try Again!");
            }
        }

        scanner.close();
    }
}

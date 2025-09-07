package BeautyAndWellnessAppointmentScheduler.Repository;

import BeautyAndWellnessAppointmentScheduler.Appointment;
import BeautyAndWellnessAppointmentScheduler.Client;
import BeautyAndWellnessAppointmentScheduler.Provider;
import BeautyAndWellnessAppointmentScheduler.Service;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collection;
import java.util.HashMap;

public class AppointmentRepository {

    private final String filePath = "Repository/appointment.csv";
    private HashMap<String, Appointment> appointmentHashMap = new HashMap<>();

    private final ClientRepository clientRepository;
    private final ProviderRepository providerRepository;
    private final ServiceRepository serviceRepository;

    public AppointmentRepository(ClientRepository clientRepository,
                                 ProviderRepository providerRepository,
                                 ServiceRepository serviceRepository){
        this.clientRepository = clientRepository;
        this.providerRepository = providerRepository;
        this.serviceRepository = serviceRepository;
    }

    public void addAppointment(Appointment appointment){
        appointmentHashMap.put(appointment.getAppointmentId(), appointment);
        saveToFile();
    }

    public Appointment getAppointmentById(String id){
        return appointmentHashMap.get(id);
    }

    public Collection<Appointment> getAllAppointments(){
        return appointmentHashMap.values();
    }

    public void saveToFile(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            for(Appointment a: appointmentHashMap.values()){
                writer.write(a.getAppointmentId() + "," + a.getClient().getClientId()
                        + "," + a.getProvider().getProviderId()  + "," +
                        a.getService().getServiceId() + "," + a.getAppointmentDate() + "," +
                        a.getAppointmentTime() + "," + a.isDone());
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(){
        appointmentHashMap.clear();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] fields = line.split(",");
                String appointmentId = fields[0];
                Client client = clientRepository.getClientById(fields[1]);
                Provider provider = providerRepository.getProviderById(fields[2]);
                Service service = serviceRepository.getServiceById(fields[3]);
                String date = fields[4];
                String time = fields[5];
                boolean isDone = Boolean.parseBoolean(fields[6]);

                if(client != null && provider != null && service != null){
                    Appointment appointment = new Appointment(appointmentId, client,
                            provider, service, date, time, isDone);
                    appointmentHashMap.put(appointmentId, appointment);
                }else{
                    System.out.println("Skipping appointment due to missing reference");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

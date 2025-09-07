package BeautyAndWellnessAppointmentScheduler.Repository;

import BeautyAndWellnessAppointmentScheduler.Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collection;
import java.util.HashMap;

public class ServiceRepository {

    private HashMap<String, Service> serviceHashMap = new HashMap<>();
    private final String filePath = "Repository/services.csv";


    public void addService(Service service){
        serviceHashMap.put(service.getServiceId(), service);
        saveToFile();
    }

    public Service getServiceById(String Id){
        return serviceHashMap.get(Id);
    }

    public Collection<Service> getAllServices(){
        return serviceHashMap.values();
    }

    public void saveToFile(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            for(Service s : serviceHashMap.values()){
                writer.write(s.getServiceId() + "," + s.getName() + "," + s.getPrice() + "," + s.getDurationInMinutes());
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(){
        serviceHashMap.clear();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = reader.readLine()) != null){
                String[] fields = line.split(",");
                Service s = new Service(fields[0], fields[1], Double.parseDouble(fields[2]), Integer.parseInt(fields[3]));
                serviceHashMap.put(s.getServiceId(), s);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

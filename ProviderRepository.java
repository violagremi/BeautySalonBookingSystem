package BeautyAndWellnessAppointmentScheduler.Repository;

import BeautyAndWellnessAppointmentScheduler.Provider;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collection;
import java.util.HashMap;

public class ProviderRepository {

    private HashMap<String, Provider> providerHashMap = new HashMap<>();
    private final String filePath = "Repository/provider.csv";

    public void addProvider(Provider provider){
        providerHashMap.put(provider.getProviderId(), provider);
        saveToFile();
    }

    public Provider getProviderById(String id){
        return providerHashMap.get(id);
    }

    public Collection<Provider> getAllProviders(){
        return providerHashMap.values();
    }

    public void saveToFile(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            for(Provider p :providerHashMap.values()){
                writer.write(p.getProviderId() + "," + p.getServiceProviderName()
                        + "," + p.getTypeOfService() + "," + p.isAvailable()
                        + "," + p.getYearsOfExperience() + "," +p.getRating() + "," +
                        p.getWorkingHours());
                writer.newLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadFromFile(){
        providerHashMap.clear();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line= reader.readLine()) != null){
                String[] fields = line.split(",");
                Provider p = new Provider(fields[0], fields[1], fields[2],
                        Boolean.parseBoolean(fields[3]),
                                Integer.parseInt(fields[4]),
                        Double.parseDouble(fields[5]), Integer.parseInt(fields[6]));
                providerHashMap.put(p.getProviderId(), p);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

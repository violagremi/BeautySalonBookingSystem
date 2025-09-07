package BeautyAndWellnessAppointmentScheduler.Repository;

import BeautyAndWellnessAppointmentScheduler.Client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collection;
import java.util.HashMap;

public class ClientRepository {

    private HashMap<String, Client> clientHashMap = new HashMap<>();
    private final String filePath = "Repository/clients.csv";

    public void addClient(Client client) {
        clientHashMap.put(client.getClientId(), client);
        saveToFile();
    }

    public Client getClientById(String id) {
        return clientHashMap.get(id);
    }

    public Collection<Client> getAllClients() {
        return clientHashMap.values();
    }

    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter((new FileWriter(filePath)))) {
            for (Client c : clientHashMap.values()) {
                writer.write(c.getClientId() + "," + c.getClientName() + "," +
                        c.getClientNumber() + "," + c.getClientEmail() + "," +
                        c.getPreferredService());
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(){
        clientHashMap.clear();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] fields = line.split(",");
                Client c = new Client(fields[0], fields[1], fields[2], fields[3], fields[4]);
                clientHashMap.put(c.getClientId(), c);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


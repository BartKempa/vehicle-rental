package org.example.model;

import java.util.HashMap;
import java.util.Map;

public class Rental {
    private Map<String, User> users = new HashMap<>();
    private Map<String, Vehicle> vehicles = new HashMap<>();

    public Map<String, User> getUsers() {
        return users;
    }

    public Map<String, Vehicle> getVehicles() {
        return vehicles;
    }

    public void addUser(User user){
        users.put(user.getPesel(), user);
    }

    public void addVehicle(Vehicle vehicle){
        vehicles.put(vehicle.getRegistrationNumber(), vehicle);
    }

    public boolean removeVehicle(Vehicle vehicle){
        if (vehicles.containsKey(vehicle.getRegistrationNumber())){
            vehicles.remove(vehicle.getRegistrationNumber());
            return true;
        } else {
            return false;
        }
    }



}

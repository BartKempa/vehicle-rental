package org.example.model;

import org.example.exception.UserAlreadyExist;
import org.example.exception.VehicleAlreadyExist;

import java.io.Serializable;
import java.util.*;

public class Rental implements Serializable {
    private Map<String, User> users = new HashMap<>();
    private Map<String, Vehicle> vehicles = new HashMap<>();
    public Map<String, User> getUsers() {
        return users;
    }
    public Map<String, Vehicle> getVehicles() {
        return vehicles;
    }
    public Collection<Vehicle> sortVehicle(Comparator<Vehicle> comparator) {
        List<Vehicle> list = new ArrayList<>(vehicles.values());
        list.sort(comparator);
        return list;
    }

    public void addUser(User user){
        if (users.containsKey(user.getPesel())){
            throw new UserAlreadyExist("Osoba o podanym peselu już jest w bazie " + user.getPesel());
        } else {
            users.put(user.getPesel(), user);
        }
    }

    public void addVehicle(Vehicle vehicle){
        if (vehicles.containsKey(vehicle.getRegistrationNumber())){
            throw new VehicleAlreadyExist("Pojazd o podanym numerze rejestracyjnym już istanieje " + vehicle.getRegistrationNumber());
        } else {
            vehicles.put(vehicle.getRegistrationNumber(), vehicle);
        }
    }

    public boolean deleteVehicle(Vehicle vehicle) {
        if (vehicles.containsKey(vehicle.getRegistrationNumber())){
            vehicles.remove(vehicle.getRegistrationNumber());
            return true;
        } else {
            return false;
        }
    }
}

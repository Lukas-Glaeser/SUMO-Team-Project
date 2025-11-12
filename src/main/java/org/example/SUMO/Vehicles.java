package org.example.SUMO;

import de.tudresden.sumo.cmd.Vehicle;
import it.polito.appeal.traci.SumoTraciConnection;
import java.util.List;

public class Vehicles {
    private SumoTraciConnection conn;

    public Vehicles(SumoTraciConnection conn) {
        this.conn = conn;
    }

    // add Vehicles:
    public void AddVehicle(String name, double speed) {
        try {
            conn.do_job_set(Vehicle.add(name, "car", "r0", 0, 0.0, speed, (byte) 0));
            System.out.println("vehicle " + name + " added");
        } catch (Exception e) {
            System.out.println("Error while adding!");
        }
    }

    // read speed:
    public void ReadSpeed(String name) {
        try {
            double speed = (double) conn.do_job_get(Vehicle.getSpeed(name));
            System.out.println(name + ": " + speed + " m/s");
        } catch (Exception e) {
            System.out.println("Error during reading!");
        }
    }

    // change speed:
    public void ChangeSpeed(String name, double speed) {
        try {
            conn.do_job_set(Vehicle.setSpeed(name, speed));
            System.out.println(name + " now " + speed + " m/s");
        } catch (Exception e) {
            System.out.println("Error while updating!");
        }
    }

    // show all vehicles:
    public void ShowAll() {
        try {
            List<String> ids = (List<String>) conn.do_job_get(Vehicle.getIDList());
            System.out.println("Vehicles: " + ids.size());
            for (String id : ids) {
                System.out.println("  - " + id);
            }
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }
}
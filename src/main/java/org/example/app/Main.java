package org.example.app;

import org.example.SUMO.*;
import de.tudresden.sumo.cmd.Simulation;

//This is a Temp class for Testing due to being not wrapped and OOP oriented
//if you have working code add it to the MainApp class

class Main {
    public static void main(String[] args) {
        connectSUMO conn = new connectSUMO();
        conn.StartconnectSUMO();

        if (conn.getSUMOConnection() == null) {
            System.out.println("canceled!");
            return;
        }

        try {
            Thread.sleep(2000);
        } catch (Exception e) {}

        Vehicles v = new Vehicles(conn.getSUMOConnection());

        v.AddVehicle("vehicle1", 10.0);
        v.AddVehicle("vehicle2", 8.0);
        v.AddVehicle("vehicle3", 12.0);

        int step = 0;
        int maxSteps = 500;  // limit

        // runs as long as there are vehicles in the simulation!
        try {
            while (step < maxSteps) {
                conn.StepconnectSUMO();

                // check if there are still vehicles in the simulation
                int minExpected = (Integer) conn.getSUMOConnection()
                        .do_job_get(Simulation.getMinExpectedNumber());

                if (minExpected == 0) {
                    System.out.println("All vehicles are done!");
                    break;
                }

                if (step % 20 == 0) {
                    System.out.println("Step " + step + " - Car remaining: " + minExpected);
                }

                Thread.sleep(200);
                step++;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nSimulation ended after " + step + " Steps");
        v.ShowAll();

        conn.CloseconnectSUMO();
    }
}
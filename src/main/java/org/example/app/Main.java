package org.example.app;

import org.example.SUMO.*;
import de.tudresden.sumo.cmd.Simulation;

class Main {
    public static void main(String[] args) {
        connectSUMO conn = new connectSUMO();
        conn.StartconnectSUMO();

        if (conn.getSUMOConnection() == null) {
            System.out.println("ABBRUCH!");
            return;
        }

        try { Thread.sleep(2000); } catch (Exception e) {}

        Vehicles v = new Vehicles(conn.getSUMOConnection());

        v.AddVehicle("auto1", 10.0);
        v.AddVehicle("auto2", 8.0);
        v.AddVehicle("auto3", 12.0);

        int step = 0;
        int maxSteps = 500;  // Sicherheitsgrenze

        // Läuft solange noch Autos in der Simulation sind!
        try {
            while (step < maxSteps) {
                conn.StepconnectSUMO();

                // Prüfe ob noch Autos da sind
                int minExpected = (Integer) conn.getSUMOConnection()
                        .do_job_get(Simulation.getMinExpectedNumber());

                if (minExpected == 0) {
                    System.out.println("Alle Fahrzeuge fertig!");
                    break;
                }

                if (step % 20 == 0) {
                    System.out.println("Step " + step + " - Autos übrig: " + minExpected);
                }

                Thread.sleep(200);
                step++;
            }
        } catch (Exception e) {
            System.out.println("Fehler: " + e.getMessage());
        }

        System.out.println("\nSimulation beendet nach " + step + " Steps");
        v.ShowAll();

        conn.CloseconnectSUMO();
    }
}
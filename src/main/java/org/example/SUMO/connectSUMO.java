package org.example.SUMO;

import it.polito.appeal.traci.*;

public class connectSUMO {

    private String sumo = "C:\\Program Files (x86)\\Eclipse\\Sumo\\bin\\sumo-gui.exe";
    private String config = "C:\\Users\\eliss\\Documents\\SUMO\\simple\\simple.sumocfg";
    private SumoTraciConnection conn;

    public connectSUMO() {}

    public void StartconnectSUMO() {
        try {
            System.out.println("Starte SUMO...");
            conn = new SumoTraciConnection(sumo, config);
            conn.runServer();
            System.out.println("SUMO verbunden!");
        } catch (Exception e) {
            System.out.println("ERROR: Konnte nicht verbinden mit SUMO");
            e.printStackTrace();
        }
    }

    public void CloseconnectSUMO() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("SUMO geschlossen");
            } catch (Exception e) {
                System.out.println("Fehler beim Schließen");
            }
        }
    }

    public void StepconnectSUMO() {
        if (conn != null) {
            try {
                conn.do_timestep();
            } catch (Exception e) {
                System.out.println("ERROR: Konnte keinen Step machen");
            }
        }
    }

    public SumoTraciConnection getSUMOConnection() {
        return conn;
    }
}
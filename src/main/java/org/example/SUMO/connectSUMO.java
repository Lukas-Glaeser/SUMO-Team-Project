package org.example.SUMO;

import it.polito.appeal.traci.*;

//For testing only use SUMOConnection to connect to sumo
//This code is later not needed for the finished project
//Remember to delete it and change the connections to other classes

public class connectSUMO {

    private String sumo = "C:\\Program Files (x86)\\Eclipse\\Sumo\\bin\\sumo-gui.exe";
    private String config = "C:\\Users\\eliss\\Documents\\SUMO\\simple\\simple.sumocfg";
    private SumoTraciConnection conn;

    public connectSUMO() {}

    public void StartconnectSUMO() {
        try {
            System.out.println("start SUMO...");
            conn = new SumoTraciConnection(sumo, config);
            conn.runServer();
            System.out.println("SUMO is connected!");
        } catch (Exception e) {
            System.out.println("ERROR: couldn't be connected");
            e.printStackTrace();
        }
    }

    public void CloseconnectSUMO() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("SUMO closed");
            } catch (Exception e) {
                System.out.println("Error while closing");
            }
        }
    }

    public void StepconnectSUMO() {
        if (conn != null) {
            try {
                conn.do_timestep();
            } catch (Exception e) {
                System.out.println("ERROR: couldn't perform a step");
            }
        }
    }

    public SumoTraciConnection getSUMOConnection()
    {
        return conn;
    }
}
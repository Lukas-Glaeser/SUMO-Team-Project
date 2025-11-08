package org.example.app;
import org.example.SUMO.*;
import it.polito.appeal.traci.*;
//import de.tudresden.sumo.*;

class MainApp {
    public static void main(String[] args) {
        SUMOConnection conn = new SUMOConnection();
        try {

            conn.StartSUMOConnection();
        }catch (Exception e){
            System.out.println("ERROR cannot connect");
        }

        TrafficLight TLights = new TrafficLight(conn.getSUMOConnection());
        TLights.LoadTrafficLights();

        for (int i = 0; i < 100; i++) {
            conn.StepSUMOConnection();
        }

        conn.CloseSUMOConnection();
    }
}
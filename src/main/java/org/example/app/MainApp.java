package org.example.app;
import org.example.SUMO.*;
import it.polito.appeal.traci.*;
import org.example.SUMO.SUMOConnection;
//import de.tudresden.sumo.*;

class MainApp {

    public static void main(String[] args) {

//Makes a new object for the SUMO Connection
        SUMOConnection conn = new SUMOConnection();

        try {
//Calls Method from SUMOConnection to start a SUMO Connection
            conn.StartSUMOConnection();
        }catch (Exception e){
            System.out.println("ERROR cannot connect");
        }

//Do 100 SUMO steps
        for (int i = 0; i < 100; i++) {
            conn.StepSUMOConnection();
        }

//Makes a new object for traffic lights with the current SUMO Connection
        TrafficLight TLights = new TrafficLight(conn.getSUMOConnection());

//Calls a Method that Loads all traffic lights from the sumo config
        TLights.LoadTrafficLights();


//Closes the SUMO Connection
        conn.CloseSUMOConnection();


    }
}
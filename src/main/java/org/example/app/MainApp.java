package org.example.app;
import org.example.SUMO.*;
import org.example.SUMO.SUMOConnection;
import javafx.scene.*;
//import de.tudresden.sumo.*;

//Only add code that is OOP and wrapped meaning that this class only calls for methods
//if the ide cant find the sumo or/and config file please change it in the SUMOConnection
//change the SUMOEXE or/and SUMOConfigFile String variables to youre path

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

//Makes a new object for traffic lights with the current SUMO Connection
        TrafficLightControl TLights = new TrafficLightControl(conn.getSUMOConnection());

//Calls a Method that Loads all traffic lights from the sumo config
        TLights.LoadTrafficLights();


//Do 100 SUMO steps
        System.out.println("Time Steps");
        for (int i = 0; i < 100; i++) {
            conn.StepSUMOConnection();
            System.out.println("Time Step: " + i);
        }

//Closes the SUMO Connection
        conn.CloseSUMOConnection();


    }
}
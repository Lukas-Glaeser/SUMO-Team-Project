package org.example.SUMO;

import de.tudresden.sumo.cmd.Trafficlight;
import it.polito.appeal.traci.SumoTraciConnection;
import org.example.Object.TrafficLight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrafficLightControl {

    private SumoTraciConnection conn;
    //private String id;
    //private List<String> TrafficLightsIDs = new ArrayList<>();
    private Map<String, TrafficLight> light = new HashMap<>();

    //Connects to the current SUMO Connection
    public TrafficLightControl(SumoTraciConnection conn){

        this.conn = conn;
    }

    //Loads the Traffic lights from the current SUMO Connection
    public void LoadTrafficLights(){
        try {
            List<String> ids = (List<String>) conn.do_job_get(Trafficlight.getIDList());

            //System.out.println("Printing Traffic Lights.");
            for(String id : ids){
                light.putIfAbsent(id, new TrafficLight(id));

            //System.out.println(id);
            }

            }catch (Exception a){
                System.out.println("ERROR could not load Traffic lights!");
            }

    }


    //Returns the selected Traffic Light
    public TrafficLight getLight(String ID){

        return light.get(ID);
    }

    //Returns the current State from te selected Traffic Light
    public String getTrafficLightState(String ID){
        try {
            String TLightState = (String) conn.do_job_get(Trafficlight.getCompleteRedYellowGreenDefinition(ID));
        }catch (Exception a){
            System.out.println("ERROR");
        }
            return "TEMP";
    }


    //Returns the current State from te selected Traffic Light
    public void setTrafficLightState(String ID,String State){


    }

}

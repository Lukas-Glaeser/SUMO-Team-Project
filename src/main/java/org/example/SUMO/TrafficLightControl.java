package org.example.SUMO;

import de.tudresden.sumo.cmd.Trafficlight;
import it.polito.appeal.traci.SumoTraciConnection;

import java.util.ArrayList;
import java.util.List;

public class TrafficLightControl {

    private SumoTraciConnection conn;
    //private String id;
    private List<String> TrafficLightsIDs = new ArrayList<>();

    //Connects to the current SUMO Connection
    public TrafficLightControl(SumoTraciConnection conn){

        this.conn = conn;
    }

    //Loads the Traffic lights from the current SUMO Connection
    public void LoadTrafficLights(){
        try {
            List<String> ids = (List<String>) conn.do_job_get(Trafficlight.getIDList());

            System.out.println("Printing Traffic Lights.");
            for(String id : ids){
            System.out.println(id);
            }

            }catch (Exception a){
                System.out.println("ERROR could not load Traffic lights!");
            }

    }


    //Returns the selected Traffic Light
    public List<String> getTrafficLight(String ID){
        return TrafficLightsIDs;
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

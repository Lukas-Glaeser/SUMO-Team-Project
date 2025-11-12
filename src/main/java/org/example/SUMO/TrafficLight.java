package org.example.SUMO;

import de.tudresden.sumo.cmd.Trafficlight;
import it.polito.appeal.traci.SumoTraciConnection;

import java.util.ArrayList;
import java.util.List;

public class TrafficLight {

    private SumoTraciConnection conn;
    //private String id;
    private List<String> TrafficLightsIDs = new ArrayList<>();

    //Connects to the current SUMO Connection
    public TrafficLight(SumoTraciConnection conn){
        this.conn = conn;
    }

    //Loads the Traffic lights from the current SUMO Connection
    public void LoadTrafficLights(){
        try {
            List<String> ids = (List<String>) conn.do_job_get(Trafficlight.getIDList());
            TrafficLightsIDs.clear();
            TrafficLightsIDs.addAll(ids);

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

        return "TEMP";
    }


    //Returns the current State from te selected Traffic Light
    public void setTrafficLightState(String ID,String State){


    }

}

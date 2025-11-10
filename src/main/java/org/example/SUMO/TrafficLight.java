package org.example.SUMO;

import de.tudresden.sumo.cmd.Trafficlight;
import it.polito.appeal.traci.SumoTraciConnection;

import java.util.List;

public class TrafficLight {

    private SumoTraciConnection conn;
    private String id;

//Connects to the current SUMO Connection
    public TrafficLight(SumoTraciConnection conn){
        this.conn = conn;
    }

//Loads the Traffic lights from the current SUMO Connection
    public void LoadTrafficLights(){
        try {
            List<String> ids = (List<String>) conn.do_job_get(Trafficlight.getIDList());

        for(String id : ids){
            System.out.println(id);
        }

        }catch (Exception a){
            System.out.println("ERROR could not load Traffic lights!");
        }

    }

}

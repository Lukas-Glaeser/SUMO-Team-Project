package org.example.SUMO;

import de.tudresden.sumo.cmd.Trafficlight;
import it.polito.appeal.traci.SumoTraciConnection;

import java.util.List;

public class TrafficLight {

    private SumoTraciConnection conn;
    private String id;

    public TrafficLight(SumoTraciConnection conn){
        this.conn = conn;
    }

    public void LoadTrafficLights(){
        try {
            List<String> ids = (List<String>) conn.do_job_get(Trafficlight.getIDList());

        for(String id : ids){
            System.out.println(id);
        }

        }catch (Exception a){

        }

    }

}

package org.example.SUMO;

import it.polito.appeal.traci.*;
import de.tudresden.sumo.cmd.*;

import java.io.IOException;
import java.sql.Connection;

public class SUMOConnection {

    private final int Port = 8813;
    private String SUMOEXE = "C:\\Program Files (x86)\\Eclipse\\Sumo\\bin\\sumo-gui.exe";
    private String SUMOConfigFile = "C:\\Studium\\Java\\Test Pro\\TraffiTest.sumocfg";
    private SumoTraciConnection conn;

    public void StartSUMOConnection(){
        try {
            conn = new SumoTraciConnection(SUMOEXE, SUMOConfigFile);

            conn.runServer(Port);
        }catch (Exception a){
            System.out.println("ERROR didnt make connection with SUMO");
        }
    }

    public void CloseSUMOConnection(){

        conn.close();

    }

    public void StepSUMOConnection(){
        try{
            conn.do_timestep();
        } catch (Exception e) {
            throw new RuntimeException("ERROR could not do step",e);
        }
    }

    public SumoTraciConnection getSUMOConnection(){
        return conn;
    }
}

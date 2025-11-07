package org.example.SUMO;

import it.polito.appeal.traci.*;
import de.tudresden.sumo.cmd.*;

import java.io.IOException;

public class SUMOConnection {

    private final int Port = 8813;
    private String SUMOEXE = "C:\\Program Files (x86)\\Eclipse\\Sumo\\bin\\sumo-gui.exe";
    private String SUMOConfigFile = "C:\\Studium\\Java\\Test Pro\\ConigTest.sumocfg";
    private SumoTraciConnection Connection;

    public void StartSUMOConnection() throws IOException {

        Connection = new SumoTraciConnection(SUMOEXE, SUMOConfigFile);

        Connection.runServer(Port);

    }

    public void CloseSUMOConnection(){

        Connection.close();

    }

    public void StepSUMOConnection(){
        try{
            Connection.do_timestep();
        } catch (Exception e) {
            throw new RuntimeException("ERROR could not do step",e);
        }
    }
}

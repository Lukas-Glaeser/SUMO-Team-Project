package org.example.SUMO;

import it.polito.appeal.traci.*;

public class SUMOConnection {

//    private final int Port = 8813;
    private String SUMOEXE = "C:\\Program Files (x86)\\Eclipse\\Sumo\\bin\\sumo-gui.exe";
    private String SUMOConfigFile = "C:\\Studium\\Java\\Test Pro\\TraffiTest.sumocfg";
    private SumoTraciConnection conn;
//Default constructor
    public SUMOConnection(){}

//Starts a SUMO Connection and opens it in SUMO with the SUMO EXE and the SUMO Config file
    public void StartSUMOConnection(){
        try {
            conn = new SumoTraciConnection(SUMOEXE, SUMOConfigFile);

            conn.runServer();

            conn.setOrder(1);

            System.out.println("SUMO connection started.");
        }catch (Exception a){
            System.out.println("ERROR didnt make connection with SUMO");
        }
    }

//Closes the SUMO Connection
    public void CloseSUMOConnection(){

        conn.close();

    }

//Does 1 step in SUMO
    public void StepSUMOConnection(){
        try{
            conn.do_timestep();
        } catch (Exception e) {
            throw new RuntimeException("ERROR could not do step",e);
        }
    }

//Returns the current SUMO Connection
    public SumoTraciConnection getSUMOConnection(){
        return conn;
    }
}

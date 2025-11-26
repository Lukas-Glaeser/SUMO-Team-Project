package org.example.Object;

public class TrafficLight {

    private String ID;
    private String currentState;


    public TrafficLight(String ID,String state){
        this.ID = ID;
        this.currentState = state;
    }

    public String getID(){
        return  ID;
    }

    public String getCurrentState(){
        return currentState;
    }

    public void setCurrentState(String newState){
        this.currentState = newState;
    }
}

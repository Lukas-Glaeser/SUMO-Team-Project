package org.example.Object;

public class TrafficLight {

    private String ID;
    private String currentState;
    private double x;
    private double y;


    public TrafficLight(String ID){
        this.ID = ID;
    }

    public String getID(){
        return  ID;
    }

    public String getCurrentState(){
        return currentState;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public void setCurrentState(String newState){
        this.currentState = newState;
    }
}

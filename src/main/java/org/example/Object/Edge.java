package org.example.Object;

public class Edge {

    private String ID;
    private double length;
    private int laneCount;
    private int vehicleCount;
    private double averageSpeed;

    public Edge(String ID){
        this.ID = ID;
    }

    public String getID(){
        return ID;
    }

    public double getLength(){
        return length;
    }

    public int getLaneCount(){
        return laneCount;
    }

    public int getVehicleCount(){
        return vehicleCount;
    }

    public double getAverageSpeed(){
        return averageSpeed;
    }

    public void setLength(double length){
        this.length = length;
    }

    public void setLength(int laneCount){
        this.laneCount = laneCount;
    }

    public void setVehicleCount(int vehicleCount){
        this.vehicleCount = vehicleCount;
    }

    public  void setAverageSpeed(double averageSpeed){
        this.averageSpeed = averageSpeed;
    }

}

package org.example.Object;

public class Vehicle {

    private String ID;
    private double speed;
    private double x;
    private double y;
    private String type;
    private String color;
    private String edgeID;

    public Vehicle(String ID){
        this.ID = ID;
    }

    public String getID(){
        return ID;
    }

    public double getSpeed(){
        return speed;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public String getType(){
        return type;
    }

    public String getColor(){
        return color;
    }

    public String getEdgeID(){
        return edgeID;
    }

    public void setSpeed(double speed){
        this.speed = speed;
    }
/*
    public void setX(double X){
        this.x = x;
    }

    public void setY(double Y){
        this.y = y;
    }
*/
    public void setPosition(double X,double Y){
        this.x = X;
        this.y = Y;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setEdgeID(String edgeID){
        this.edgeID = edgeID;
    }
}

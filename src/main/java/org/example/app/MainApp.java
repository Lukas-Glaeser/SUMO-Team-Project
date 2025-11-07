package org.example.app;
import org.example.SUMO.*;
import it.polito.appeal.traci.*;
import de.tudresden.sumo.*;

class MainApp {
    public static void Main(String[] args) {
        SUMOConnection conn = new SUMOConnection();

        try {
            conn = new SUMOConnection();
            conn.StartSUMOConnection();
        }catch (Exception e){
            System.out.println("ERROR cannot connect");
        }
        for (int i = 0; i < 100; i++) {
            conn.StepSUMOConnection();
        }

        conn.CloseSUMOConnection();
    }
}
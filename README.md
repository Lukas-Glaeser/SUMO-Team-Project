Real-Time Traffic Simulation with Java and SUMO

Description of the project:
The goal of this project is to create a real-time traffic simulation platform that uses the SUMO mobility engine and is managed from Java using the TraaS API. 
While our Java code connects to a running SUMO instance and manages the simulation step-by-step, SUMO is in charge of the actual traffic simulation (road network, cars, traffic signals).  
The finished system ought to:
- Connect, step the simulation, inject vehicles, retrieve data, control signals, and integrate SUMO live.
- Use a graphical user interface (GUI) to see the traffic lights, cars, and road network.
- Permit user interaction (e.g., adding cars, altering traffic signals), and gather data for analysis, such as average speed, density, or journey duration.

 Team members:
- Lukas  
- Elissar 
- Malaz
- Ebrar
- .

What we have done so far:
So far we mainly focused on getting the *technical foundation* to work:
- We created a Maven project in GitHub so the whole team can work with the same structure and shared dependencies.
- TraaS is included as a dependency, so we can use it to talk to SUMO from Java.
- We set up several branches in GitHub so each team member can work on their part without breaking the main branch(master).

From the perspective of simulation:
We created a SumoConnections.java class that uses our simple.sumocfg setup to launch SUMO from IntelliJ.
 -  The class establishes a connection with SUMO, advances the simulation, and spawns several vehicles on a route automatically.
 -  Instead of only running for a predetermined number of steps, the simulation loop is designed to run until all vehicles have departed the network.
 -  In order to determine how long the scenario took, we print the entire simulation time at the conclusion of the run.
 -  In parallel to the vehicle logic, another team member started working on the traffic-light part. There is a similar setup (a connection to SUMO and a traffic-light class),
    and later this will be combined with the vehicle simulation so that cars and traffic lights work together correctly.

    









 

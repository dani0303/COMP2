package queues;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Route {
    LinkedQueue<Station> stations;
    int busCapacity;
    int busInterval;

    Random random;

    public Route(String filename) {
        try {
            File myfile = new File(filename);
            Scanner s = new Scanner(myfile);
            while (s.hasNextLine()) {
                String str = s.nextLine();
                // 
                Station station = new Station(str, 15);
                this.stations.enqueue(station);
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }


    }

    public void generatePassengers(Random r) {


        QueueInterface<Passenger> passengers = new LinkedQueue<>();
        int numberOfPassengers = r.nextInt(15) + 1;
        int id = r.nextInt(10000) + 1;
        for (int i = 0; i < numberOfPassengers; i++) {
            Passenger passenger = new Passenger(id, );
            passengers.enqueue(passenger);
        }
    }

}

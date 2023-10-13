package queues;

class Station {
    String name;
    QueueInterface<Passenger> passengerQueue;
    int statioinCapacity;

    public Station(String name, int stationCapacity) {
        this.name = name;
        this.statioinCapacity = stationCapacity;
        this.passengerQueue = new LinkedQueue<>();
    }
}


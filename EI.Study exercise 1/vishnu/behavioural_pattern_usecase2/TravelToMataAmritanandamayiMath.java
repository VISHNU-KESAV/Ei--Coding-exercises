interface TransportationStrategy {
    void travel(String source, String destination);
}

class AirTravel implements TransportationStrategy {
    private double cost;
    private double time;

    public AirTravel(double cost, double time) {
        this.cost = cost;
        this.time = time;
    }

    @Override
    public void travel(String source, String destination) {
        System.out.println("Traveling from " + source + " to " + destination + " by flight.");
        System.out.println("Cost: $" + cost + ", Estimated Time: " + time + " hours.");
    }
}

class TrainTravel implements TransportationStrategy {
    private double cost;
    private double time;

    public TrainTravel(double cost, double time) {
        this.cost = cost;
        this.time = time;
    }

    @Override
    public void travel(String source, String destination) {
        System.out.println("Traveling from " + source + " to " + destination + " by train.");
        System.out.println("Cost: $" + cost + ", Estimated Time: " + time + " hours.");
    }
}

class CarTravel implements TransportationStrategy {
    private double cost;
    private double time;

    public CarTravel(double cost, double time) {
        this.cost = cost;
        this.time = time;
    }

    @Override
    public void travel(String source, String destination) {
        System.out.println("Traveling from " + source + " to " + destination + " by car.");
        System.out.println("Cost: $" + cost + ", Estimated Time: " + time + " hours.");
    }
}

class Traveler {
    private String name;
    private TransportationStrategy transportationStrategy;

    public Traveler(String name) {
        this.name = name;
    }

    public void setTransportationStrategy(TransportationStrategy transportationStrategy) {
        this.transportationStrategy = transportationStrategy;
    }


    public void travelToDestination(String source, String destination) {
        if (transportationStrategy == null) {
            System.out.println("No transportation method selected.");
        } else {
            System.out.println(name + " is ready to travel.");
            transportationStrategy.travel(source, destination);
        }
    }
}


public class TravelToMataAmritanandamayiMath {
    public static void main(String[] args) {
        String destination = "Mata Amritanandamayi Math, Kerala, India";
        
        Traveler traveler = new Traveler("Rakesh");

        String sourceUSA = "New York, USA";
        String sourceUK = "London, UK";
        String sourceIndia = "Mumbai, India";

        TransportationStrategy airTravelFromUSA = new AirTravel(1200, 20);  
        traveler.setTransportationStrategy(airTravelFromUSA);
        traveler.travelToDestination(sourceUSA, destination);

        System.out.println();

        TransportationStrategy trainTravelFromIndia = new TrainTravel(50, 24);  
        traveler.setTransportationStrategy(trainTravelFromIndia);
        traveler.travelToDestination(sourceIndia, destination);

        System.out.println();

        TransportationStrategy carTravelFromMumbai = new CarTravel(100, 15);
        traveler.setTransportationStrategy(carTravelFromMumbai);
        traveler.travelToDestination(sourceIndia, destination);
    }
}


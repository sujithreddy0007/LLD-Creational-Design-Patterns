package abstract_factory_design_pattern;

interface Vehicle {
    void start();
    void stop();
}

interface VehicleFactory {
    Vehicle createVehicle();
}

class BMW implements Vehicle {
    public void start() {
        System.out.println("BMW Car is starting");
    }
    public void stop() {
        System.out.println("BMW Car is stopping");
    }
}

class Honda implements Vehicle {
    public void start() {
        System.out.println("Honda Car is starting");
    }
    public void stop() {
        System.out.println("Honda Car is stopping");
    }
}

class Toyota implements Vehicle {
    public void start() {
        System.out.println("Toyota Car is starting");
    }
    public void stop() {
        System.out.println("Toyota Car is stopping");
    }
}

class BMWFactory implements VehicleFactory {
    public Vehicle createVehicle() {
        return new BMW();
    }
}

class HondaFactory implements VehicleFactory {
    public Vehicle createVehicle() {
        return new Honda();
    }
}

class ToyotaFactory implements VehicleFactory {
    public Vehicle createVehicle() {
        return new Toyota();
    }
}

public class Client {
    public static void main(String[] args) {
        VehicleFactory hondaFactory = new HondaFactory(); // can be dynamic
        Vehicle honda = hondaFactory.createVehicle();
        honda.start();
        honda.stop();
        VehicleFactory toyotaFactory = new ToyotaFactory();
        Vehicle toyota = toyotaFactory.createVehicle();
        toyota.start();
        toyota.stop();
    }
}

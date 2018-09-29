package GOF.factoryMethod;


public class AudiFactory implements CarFactory {

    public Car createCar() {
        return new Audi();
    }
}

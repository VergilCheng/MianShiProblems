package GOF.factoryMethod;


public class BydFactory implements CarFactory {

    public Car createCar() {
        return new BYD();
    }
}

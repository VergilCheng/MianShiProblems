package GOF.factoryMethod;

public class BenzFactory implements CarFactory{


    public Car createCar() {
        return new Benz();
    }
}

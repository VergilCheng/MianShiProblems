package GOF.factoryMethod;

import org.junit.Test;

public class Client {


    @Test
    public void test1() {
        Car c1 = new AudiFactory().createCar();
        Car c2 = new BydFactory().createCar();
        Car c3 = new BenzFactory().createCar();
        c1.run();
        c2.run();
        c3.run();
    }

}

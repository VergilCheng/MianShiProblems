package GOF.abstractFactory;

import org.junit.Test;

public class Client {
    @Test
    public void test1() {
        CarFactory luxuryFactory = new LuxuryCarFactory();
        Engine luxuryFactoryEngine = luxuryFactory.createEngine();
        luxuryFactoryEngine.run();
        luxuryFactoryEngine.start();
        Seat luxuryFactorySeat = luxuryFactory.createSeat();
        luxuryFactorySeat.massage();
        Tyre luxuryFactoryTyre = luxuryFactory.createTyre();
        luxuryFactoryTyre.revolve();

    }
}

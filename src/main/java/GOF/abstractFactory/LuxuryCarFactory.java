package GOF.abstractFactory;

public class LuxuryCarFactory extends CarFactory {


    protected Engine createEngine() {
        return new LuxuryEngine();
    }

    protected Seat createSeat() {
        return new LuxurySeat();
    }

    protected Tyre createTyre() {
        return new LuxuryTyre();
    }
}

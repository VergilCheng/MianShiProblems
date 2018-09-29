package GOF.abstractFactory;

public interface Seat {

    void massage();

}

class LuxurySeat implements Seat {
    public void massage() {
        System.out.println("高端可以自动按摩");
    }
}

class LowSeat implements Seat {
    public void massage() {
        System.out.println("低端不能自动按摩");
    }
}

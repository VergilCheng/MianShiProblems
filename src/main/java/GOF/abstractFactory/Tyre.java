package GOF.abstractFactory;

public interface Tyre {

    void revolve();
}

class LuxuryTyre implements Tyre {

    public void revolve() {
        System.out.println("高端轮胎质量好");
    }
}

class LowTyre implements Tyre {

    public void revolve() {
        System.out.println("低端轮胎质量差");
    }
}

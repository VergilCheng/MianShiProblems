package GOF.builder;

public class Client {

    public static void main(String[] args) {
        AirshipDirector director = new CmzAirshipDirector(new WymAirshipBuilder());
        Airship airship = director.createAirship();
        System.out.println(airship.getEngine().getName());
    }

}

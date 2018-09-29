package GOF.builder;

/**
 * 该类是创建飞船对象的接口
 */
public interface AirshipDirector {
    Airship createAirship();
}

class CmzAirshipDirector implements AirshipDirector{

    //获取构建者对象的引用
    private AirShipBuilder builder;

    public CmzAirshipDirector(AirShipBuilder builder) {
        this.builder = builder;
    }

    public Airship createAirship() {

        //调用构造者的方法，构造组件
        Engine engine = builder.buildEngine();
        OrbitalModule orbitalModule = builder.buildOrbitalModule();
        Escape escape = builder.buildEscape();
        //创建组合者的对象，组合组件
        Airship airship = new Airship();
        airship.setEngine(engine);
        airship.setEscapeTower(escape);
        airship.setOrbitalModule(orbitalModule);
        return airship;
    }
}



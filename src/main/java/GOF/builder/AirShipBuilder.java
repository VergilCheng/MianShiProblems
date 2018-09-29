/**
 * 创建者模式
 *
 * 将各种组件结合起来的模式，我们可以类比之前的抽象工厂模式，
 * 抽象工厂模式只是将各个组件通过工厂创建出来而并没有进行组装。
 * 创建者模式则是可以创建各个组件并组装，或者通过工厂模式创建出来
 * 的组件进行组装
 *
 *
 *
 */

package GOF.builder;

/**
 * 该类是创建各个组件的接口，由于没有抽象工厂，所以我们通过这个接口创建组件
 */
public interface AirShipBuilder {
    Engine buildEngine();
    Escape buildEscape();
    OrbitalModule buildOrbitalModule();
}

/**
 * 该接口的实现类
 *
 * 常见建造者模式：StringBuilder，JDOM类库中的：SAXBuilder等
 */
class WymAirshipBuilder implements AirShipBuilder {

    public Engine buildEngine() {
        System.out.println("构建发动机");
        return new Engine("wym");
    }

    public Escape buildEscape() {
        System.out.println("构建逃逸塔");
        return new Escape("wym");
    }

    public OrbitalModule buildOrbitalModule() {
        System.out.println("构建轨道舱");
        return new OrbitalModule("wym");
    }
}

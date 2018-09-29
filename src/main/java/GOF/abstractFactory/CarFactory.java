package GOF.abstractFactory;

/**
 * 抽象工厂模式：
 * 与之前工厂模式不同点在于之前工厂对应的是单接口和多实现类，
 * 如果出现了新的接口，则需要新建新的工厂。而抽象工厂模式则是
 * 一个抽象工厂对应多个具体工厂，每个具体工厂对应多个接口。
 * 而这些接口往往是一个产品族。
 *
 */
public abstract class CarFactory {
    protected abstract Engine createEngine();

    protected abstract Seat createSeat();

    protected abstract Tyre createTyre();
}

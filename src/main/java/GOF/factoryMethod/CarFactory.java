package GOF.factoryMethod;

/**
 * 工厂方法模式，继承了简单工厂模式的优点
 * 同时还解决了简单工厂模式所不能解决的违反OCP原则
 * 的缺点，如果需要扩展新的类，则只需要继承接口工厂
 * 并重写方法即可。深刻体会面向接口编程的好处。
 *
 * 缺点是类会非常多，所以看情况而定，选择简单工厂模式或者工厂方法模式
 */
public interface CarFactory {

    Car createCar();

}

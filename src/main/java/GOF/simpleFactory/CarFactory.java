package GOF.simpleFactory;

/**
 * Car接口的工厂
 *
 * 简单工厂模式
 *
 * 简单工厂的小问题：代码扩展方面会违反OCP原则
 *
 *
 *
 */
public class CarFactory {

    /**
     * 返回一个Car类型的对象
     *
     * 该方法有点小问题，如果我们新实现了一个类，并且要通过简单工厂
     * 来创建该对象，那么就会对已有的方法进行修改，则会破坏OCP原则
     * 对开发造成困难。
     * @param type
     * @return
     */
    public static Car createCar(String type) {
        if ("Audi".equals(type)) {
            return new Audi();
        }
        if ("BYD".equals(type)) {
            return new BYD();
        }
        return null;
    }

}

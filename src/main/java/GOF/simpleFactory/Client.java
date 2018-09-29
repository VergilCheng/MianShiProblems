package GOF.simpleFactory;

import org.junit.Test;

/**
 * 简单工厂模式的各种创建对象的比较对比
 */
public class Client {

    /**
     * 演示没有工厂类的情况下，app创建对象的情况
     * 当前app回对接口，两个实现类都发生依赖关系。
     */

    @Test
    public void test1() {
        Car c1 = new BYD();
        Car c2 = new Audi();

        c1.run();
        c2.run();
    }


    /**
     * 演示简单工厂模式下创建对象,实现了解耦，Client只需要和工厂
     * 以及接口建立关系就可以，不需要和所有实现类建立关系，降低了耦合度
     *
     * 注意：从外部看来耦合度降低了，但是工厂还是和接口以及实现类建立了
     * 复杂的关系，工厂只是将这种关系封装了起来，并没有删除这种依赖关系。
     *
     */
    @Test
    public void test2() {
        Car c1 = CarFactory.createCar("Audi");
        Car c2 = CarFactory.createCar("BYD");

        c1.run();
        c2.run();
    }

}

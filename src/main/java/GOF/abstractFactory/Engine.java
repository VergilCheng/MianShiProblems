package GOF.abstractFactory;

/**
 * 引擎接口
 */
public interface Engine {

    void run();
    void start();
}

/**
 * 高端发动机
 */
class LuxuryEngine implements Engine {

    public void run() {
        System.out.println("转的快");
    }

    public void start() {
        System.out.println("启动快，可以自动停启");
    }
}

/**
 * 低端发动机
 */
class LowEngine implements Engine {

    public void run() {
        System.out.println("转的慢");
    }

    public void start() {
        System.out.println("启动慢，不可以自动停启");
    }
}
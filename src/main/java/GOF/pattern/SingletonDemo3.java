package GOF.pattern;

/**
 * 双重检测锁模式
 *
 * 特点：
 * 1.将同步范围缩小到代码内，只有第一次创建才同步，后面调用不会同步了
 * 2.看似提高了并发效率，但是由于编译器优化原因与JVM底层内部模型原因
 * 偶尔会出现问题，不建议使用。
 */
public class SingletonDemo3 {

    //step1.将该类的属性设置为自己，不进行赋值
    private static SingletonDemo3 instance ;

    //step2.将该类构造器私有化，不允许外部new
    private SingletonDemo3(){

    }
    //step3.构造一个静态方法，用来返回对象(因为不能通过new来创建实例，所以只能通过类方法来创建)
    public static  SingletonDemo3 getInstance(){
        synchronized (SingletonDemo3.class){
            if (instance == null) {
            instance = new SingletonDemo3();
            return instance;
            }
        }
        return instance;
    }

}

package ClassLoad;

/**
 * 测试简单的加密解密(取反)操作
 */
public class Demo04 {

    public static void main(String[] args) {
        int a = 3;//00000011
        System.out.println(Integer.toBinaryString(a^0xff));
    }
}

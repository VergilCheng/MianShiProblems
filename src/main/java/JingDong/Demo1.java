package JingDong;

import java.util.Scanner;

/**
 * 计算二进制与十进制位数和是否相同
 */
public class Demo1 {


    public static void main(String[] args) {
        //输入
        Scanner scanner = new Scanner(System.in);

        /*int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0;i<n;i++){
            a[i] = scanner.nextInt();
        }*/
        int n = scanner.nextInt();
        int count = 0;
        for(int i = 1;i<=n;i++) {
            String string = Integer.toString(i);
            String str = Integer.toBinaryString(i);
            int sum = 0;
            int binarySum = 0;

            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j)=='1') {
                    binarySum++;
                }
            }
            //System.out.println(binarySum);
            for (int j = 0; j < string.length(); j++) {
                Character s = string.charAt(j);
                sum = sum + Integer.parseInt(s.toString());
            }
            if (sum == binarySum) {
                count++;
            }
        }
        System.out.println(count);
    }
}

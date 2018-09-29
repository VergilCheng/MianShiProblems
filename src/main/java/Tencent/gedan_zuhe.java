package Tencent;

import java.util.Scanner;

public class gedan_zuhe {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k = Integer.parseInt(scan.nextLine());
        int a = scan.nextInt();//长度为A
        int x = scan.nextInt();//x个
        int b = scan.nextInt();//长度为b
        int y = scan.nextInt();//y个
        int result=0;
        for (int i = 0; i <=x ; i++) {
            for (int j = 0; j<=y;j++) {
                if((i*a+j*b)==k){
                    result++;
                }else if((i*a+j*b)>k){
                    break;
                }else{

                }
            }
        }
        System.out.println(result%1000000007);
    }
}

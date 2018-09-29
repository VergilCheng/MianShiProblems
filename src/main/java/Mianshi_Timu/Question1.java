package Mianshi_Timu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Question1 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[] a = new int[n];
        for(int i = 0;i<n;i++){

            a[i] =scan.nextInt() ;
        }

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i+1; j < a.length; j++) {

                int b = a[i] ^ a[j];
                list.add(b);

            }
        }
        /*for (Integer i:list){
            System.out.println(i);
        }*/
        //System.out.println(list.size());
        Integer[] arr = list.toArray(new Integer[(a.length*(a.length-1))/2]);

        for (int i = 0;i<arr.length;i++){
            System.out.print(arr[i]);
            System.out.print("\t");
        }

        System.out.println();
        Arrays.sort(arr);
        for (int i = 0;i<arr.length;i++){
            System.out.print(arr[i]);
            System.out.print("\t");
        }
        System.out.println();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > m) {
                count = i;
                break;
            }


        }

        System.out.print(arr.length-count);
    }
}

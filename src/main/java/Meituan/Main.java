package Meituan;

import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in) ;
        int n = scanner.nextInt() ;
        int k = scanner.nextInt() ;
        int t = scanner.nextInt() ;
        int[] a = new int[n] ;
        for (int i = 0 ; i < n ; i++) {
            a[i] = scanner.nextInt() ;
        }
        scanner.close();

        int count = 0 ;
        HashMap<Integer,Integer> map ;
        for (int i = 0 ; i <= n-k; i++) {
            map = new HashMap() ;
            for (int j = i ; j < i+k ; j++) {
                if (map.containsKey(a[j])) {
                    map.put(a[j],map.get(a[j])+1) ;
                } else {
                    map.put(a[j],1) ;
                }
            }

            if(Collections.max(map.values()) >= t) {
                count ++ ;
            }
        }
        System.out.println(count);
    }
}


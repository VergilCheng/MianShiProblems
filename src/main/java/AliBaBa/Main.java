package AliBaBa;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static int calculate(String[] locations) {
        int length = locations.length;
        int[][] a = new int[length][2];
        for (int i = 0;i<a.length;i++) {
                String[] str = locations[i].split(",");
                a[i][0] = Integer.parseInt(str[0]);
                a[i][1] = Integer.parseInt(str[1]);
        }
        return 0;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine().trim());
        int index = 0;
        String[] locations = new String[num];
        while(num-- > 0){
            locations[index++] = scanner.nextLine();
        }

        System.out.println(calculate(locations));
    }
}


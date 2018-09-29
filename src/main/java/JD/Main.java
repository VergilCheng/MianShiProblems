package JD;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        String T = scan.nextLine();
        //构造图
        for(int i = 0;i<Integer.parseInt(T);i++){
            createAndJuge(scan);
        }

    }

    public static void createAndJuge(Scanner scan){
        String nAndM = scan.nextLine();
        String[] strs = nAndM.split(" ");
        String M = strs[1];
        //创建一个队列，将输入的点依次放到队列中，遇到重复点则删除，如果队列最终为空则为完全多部图，如果队列不为空则不是。
        ArrayList<String> list = new ArrayList<String>();

        for(int i = 0;i<Integer.parseInt(M);i++){
            String input = scan.nextLine();
            String[]points = input.split(" ");
            /*for (int j = 0; j <points.length ; j++) {
                System.out.print(points[j]+"\t");
            }*/
            if(list.contains(points[0])){
                list.remove(points[0]);
            }else{
                list.add(points[0]);
            }
            if(list.contains(points[1])){
                list.remove(points[1]);
            }else{
                list.add(points[1]);
            }
        }
        if(list.isEmpty()){
            System.out.print("Yes");
        }else{
            System.out.print("No");
        }

    }

}

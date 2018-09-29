package Pinduoduo;

import java.util.Scanner;

public class Huowu {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        while(scan.hasNext()){
            stringBuilder.append(scan.nextLine());
        }
        String[] nums = stringBuilder.toString().split(",");
        int count = 0;

            for(int i = 0;i<nums.length/2;i++){
                int a = Integer.parseInt(nums[i]);
                int b = Integer.parseInt(nums[nums.length-i-1]);
                if((a+b)>300){
                    count+=2;
                }else{
                    count+=1;
                }

            }
        if(nums.length%2==0){
            System.out.println(count);
        }else{
            System.out.println(++count);
        }
    }

}

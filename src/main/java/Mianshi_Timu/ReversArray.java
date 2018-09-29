package Mianshi_Timu;

import java.util.Scanner;

public class ReversArray {


        public static void main(String[] args){

            //接收输入
            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();
            int[] a = new int[n];
            for(int i = 0;i<a.length;i++){
                a[i] = scan.nextInt();
            }
            int start = 0;
            int end = 0;
            int count = 0;
            //排序
            for(int i =start;i<a.length-1;i++){
                if(a[i]>a[i+1]){
                    start = i;
                    for(int j = start;j<a.length-1;i++){
                        if(a[j+1]>a[j]){
                            end = j;
                            if(a[start]<a[end+1]){
                                count++;
                                start = end+1;
                                break;
                            }else{
                                System.out.println("no");
                                return;
                            }
                        }
                    }
                }
            }
            if(count!=1){
                System.out.print("no");
            }else{
                System.out.print("yes");
            }


        }

    }



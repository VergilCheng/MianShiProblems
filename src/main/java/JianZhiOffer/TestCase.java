package JianZhiOffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestCase {


    @Test
    public void test1(){

        int n = 1;

        String str = Integer.toBinaryString(n);
        System.out.println(str);
        int length = str.length();
        System.out.println(str.charAt(0));
        if(n==0){
            System.out.println(n);
        }
        if(n<0){
            int add = 32-length;
            for(int i = 0;i<length;i++){
                if(str.charAt(i)=='1'){
                    add++;
                }
            }
            System.out.println(add);
        }else if(n>0){
            int add = 0;
            for(int i = 0;i<length;i++){
                if(str.charAt(i)=='1'){
                    add++;
                }
            }
            System.out.println(add);
        }



    }

    @Test
    public void test2(){
        int[] array = {1,2,3,4,5,6,7,3,4,5,1,3,4,5};
        List<Integer> even = new LinkedList<Integer>();
        List<Integer> odd = new LinkedList<Integer>();
        for(int i = 0;i<array.length;i++){
            if(array[i]%2==1){
                odd.add(array[i]);
            }else{
                even.add(array[i]);
            }
        }
        List<Integer> arrayList = new ArrayList<Integer>();
        for(int i = 0;i<odd.size();i++){
            arrayList.add(odd.get(i));
        }
        for(int i = 0;i<even.size();i++){
            arrayList.add(even.get(i));
        }
        System.out.println(arrayList.toString());

    }


}

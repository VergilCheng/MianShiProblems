package Mianshi_Timu;

import java.util.Stack;

public class TestStringReplace {

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("We are Happy");
        String str1 = str.toString();
        String[] strs = str1.split("");//按照空字符串切分可以得到空格字符串
        for (String s:strs) {
            System.out.println("["+s+"]");
        }
        System.out.println(str1);
        Stack stack = new Stack();
        /*StringBuffer answer = new StringBuffer("");
        String[] strs = str1.split(" ");
        for(int i = 0;i<strs.length-1;i++){
            answer.append(strs[i]);
            answer.append("%20");
        }
        answer.append(strs[strs.length-1]);
        System.out.print(asnwer.toString());
   */ }
}

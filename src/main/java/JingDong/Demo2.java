package JingDong;

import java.util.*;

public class Demo2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        TreeSet set = new TreeSet();
        for(int i = 0;i<m+n;i++){
            set.add(scanner.nextInt());
        }
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next());
            if (iterator.hasNext()){
                System.out.print(" ");
            }
        }
    }
}

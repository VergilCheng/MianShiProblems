package Mianshi_Timu;

import java.util.Iterator;
import java.util.Stack;



/**
 * 用两个栈实现队列的入队和出队
 */
public class Qusetion2 {

    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<Integer>();

        myQueue.Enqueue(1);
        myQueue.Enqueue(2);
        myQueue.Enqueue(3);
        myQueue.Enqueue(4);
        myQueue.Enqueue(5);
        myQueue.Enqueue(6);
        myQueue.Enqueue(7);

        System.out.println(myQueue.s1);


        Iterator<Integer> iterator1 = myQueue.s1.iterator();
        while (iterator1.hasNext()){
            Integer t = iterator1.next();
            System.out.println(t);
        }
        //调换到s2
        myQueue.Dequeue();
        System.out.println(myQueue.s2);

        Iterator<Integer> iterator2 = myQueue.s2.iterator();


      /*  System.out.println("遍历方法");
        System.out.println(myQueue.n);
        myQueue.Traversing();*/



       // System.out.println(myQueue.n);
        //System.out.println(myQueue.Dequeue()+"\t"+myQueue.n);
        //System.out.println(myQueue.Dequeue()+"\t"+myQueue.n);
        //System.out.println(myQueue.Dequeue()+"\t"+myQueue.n);
        //myQueue.Enqueue(8);
        //System.out.println(myQueue.Dequeue()+"\t"+myQueue.n);
        //System.out.println(myQueue.Dequeue()+"\t"+myQueue.n);
        //myQueue.Enqueue(9);
        //System.out.println(myQueue.Dequeue()+"\t"+myQueue.n);
        //System.out.println(myQueue.Dequeue()+"\t"+myQueue.n);
        //System.out.println(myQueue.Dequeue()+"\t"+myQueue.n);
        //System.out.println(myQueue.Dequeue()+"\t"+myQueue.n);





    }





}

class MyQueue<T>{
     Stack<T> s1 = new Stack<T>();//用来入;
     Stack<T> s2 = new Stack<T>();//用来出；
    int n = s1.size();//队列的元素个数

    //入队

    public void Enqueue(T x){
        while (s2.size()>0){
           T a = s2.pop();
           s1.push(a);
        }
        s1.push(x);
        n=s1.size();
    }

    public T Dequeue() throws RuntimeException{
        while (s1.size()>0){
            T x =  s1.pop();
            n-=1;
            s2.push(x);
        }
        n= s2.size()-1;
        return s2.pop();
    }

    public void Traversing(){

        while(s1.iterator().hasNext()){
            System.out.println(s1.iterator().next());
        }
        while (s2.iterator().hasNext()){
            System.out.println(s2.iterator().next());
        }



    }

}



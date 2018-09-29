package Reflect;

import java.util.Map;

public class Foo {

    private int age;
    private double salary;
    public String name;

    //测试反射操作泛型
    public Map<String,Integer> map() {
        System.out.println("map泛型信息");
        return null;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void method1() {
        System.out.println("method1");
    }

    public void method1(String str) {
        System.out.println(str);
    }

    private void test1() {
        System.out.println("test1()");
    }

    public Foo() {

    }

    public Foo(String str) {
        this.name = str;
    }

    int test2() {
        System.out.println("test2()");
        return 1;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "age=" + age +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                '}';
    }
}

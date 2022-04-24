package oop.polymorphism.test_Inheritance;

import java.util.ArrayList;

public class Child extends Parent{
    int age = 26;
    String name = "자식입니당.";

    void info(){
        System.out.println("클래스 정보 : 자식 클래스, " + this.getClass().getName());
        System.out.println("저의 이름은 " + name);
        System.out.println("저의 나이는 " + age);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        int num = list.get(0);
    }
}

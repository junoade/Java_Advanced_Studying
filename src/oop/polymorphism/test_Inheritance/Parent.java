package oop.polymorphism.test_Inheritance;

public class Parent {
    int age = 56;
    String name = "부모님입니당";

    void info(){
        System.out.println("클래스 정보 : 부모 클래스, " + this.getClass().getName());
        System.out.println("저의 이름은 " + name);
        System.out.println("저의 나이는 " + age);
    }

}

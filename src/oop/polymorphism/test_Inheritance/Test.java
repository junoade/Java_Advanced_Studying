package oop.polymorphism.test_Inheritance;

/***
 * 다형성? 하나의 참조 변수로 여러 타입의 객체를 참조할 수 있는 것,
 * 주로 클라이언트 쪽에서 어떤 것을 사용할지 모르니까, 객체지향이론에서 매우 중요한 개념
 * 동적 바인딩,
 *
 */
public class Test {
    public static void main(String[] args){
        /* 상속에서의 다형성 예시, upcasting */
        Parent p1 = new Child();
        Child c1 = new Child();

        System.out.println("부모 클래스의 참조변수로, 자식 클래스의 인스턴스 접근");
        System.out.println("부모 클래스 내의 age : " + p1.age);
        System.out.println("자식 클래스 내의 age : " + c1.age);
        p1.info();
        c1.info();

        /**
         * @결론
         * 멤버 변수가 중복 정의된 경우, 참조 변수의 타입에 따라 연결되는 멤버 변수가 달라질 수 있다.
         * 그러나 메소드가 중복 정의된 경우, 참조 변수의 타입에 관계 없이 항상 실제 인스턴스 타입에 정의된 메소드가 호출된다.
         */

        /* 다운 캐스팅 예시 */
        Parent p2 = new Parent();
        Child c2 = (Child)p2;
        System.out.println("부모 클래스의 참조변수로, 자식 클래스의 인스턴스 접근");
        System.out.println("부모 클래스 내의 age : " + p2.age);
        System.out.println("자식 클래스 내의 age : " + c2.age);
        p2.info();
        c2.info();

        /**
         * @결론
         * 위에서 아래로 대치, 아래가 더 큰 개념이이라, 컴파일 타임에서는 에러가 없지만,
         * 런타임에서 ClassCastException 발생함.
         */
    }
}

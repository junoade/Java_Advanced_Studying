package lambda.thisRefTest;

import lambda.MyTestAPI;

public class Outer {
    public int outerField = 10;

    class Inner {
        int innerField = 20;
        void innerMethod(){
            MyTestAPI mt = () -> {
                System.out.println("Outter 클래스 영역의 " + outerField); //10
                System.out.println("Outter 클래스 영역의 " + Outer.this.outerField); // 10

                /* 람다식 실행 코드에서의 this 키워드의 참조 대상 조심 */
                System.out.println("Inner 클래스 영역의 " + innerField); // 20
                System.out.println("Inner 클래스 영역의 " + this.innerField); // 20
            };
            mt.method(); // 람다식으로 작성한 함수 실행
        }
    }
}

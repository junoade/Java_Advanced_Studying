package lambda.localVarTest;

import lambda.MyTestAPI;

public class LocalVal {
    void calculate(int num) {
        int localVar = 40;

        /* 람다식에서 사용되는 변수이기 때문에, final 상수, 읽기만 가능 */
        // num = 80; // Variable used in lambda expression should be final or effectively final
        // localVar = 90; // Variable used in lambda expression should be final or effectively final
        MyTestAPI mt = () -> {
            System.out.println("the value of argument : " + num);
            System.out.println("the value of local Variable : " + localVar);
            // Variable used in lambda expression should be final or effectively final
            // localVar = 50;
        };
        mt.method();
    }
}

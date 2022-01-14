package Whiteship_livestudy.week1;

import java.util.ArrayList;

/**
 * 클래스 로더 테스트
 * JVM에는 클래스 로더, 메모리(Runtime Data areas), Execution Engine, JNI, native method library등으로 구성된다.
 * 이번에는 클래스 로더에 관련한 실습을 진행한다.
 * https://www.baeldung.com/java-classloaders
 *
 * */

public class ClassLoaderTest_01 {
    public static void main(String[] args) throws ClassNotFoundException {

        ClassLoaderTest_01 clt = new ClassLoaderTest_01();
        clt.printClassLoader();
    }

    public void printClassLoader() throws ClassNotFoundException{
        System.out.println("ClassLoader of ArrayList : " + ArrayList.class.getClassLoader());
        /***
         * null 로 출력된다.
         * 그 이유는 ArrayList 가 정의된 클래스가 Bootstrap Class Loader에 의해 로드되는데,
         * Bootstrap ClassLoader는 C나 C++ 과 같은 native code로 작성되었기 때문이다.
         * https://www.baeldung.com/java-classloaders
         */
    }
}

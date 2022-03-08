package OOP.basic.method;

public class VarargsTest {
    public static void main(String[] args){
        Varargs varargs = new Varargs();

        // Test1)
        System.out.println(varargs.concatenate("a"));
        System.out.println(varargs.concatenate("a", "b"));
        System.out.println(varargs.concatenate(new String[]{"A", "B"}));

        // Test2) note2_가변인자는 내부적으로 배열을 이용하며, 배열을 매개 변수로 전달하는 것과 차이점은
        // 가변인자는 아예 전달을 안할 수 있으나,
        // 후자는 그럴 수 없다.
        // 'failed_concat_note1(java.lang.String[])' in 'OOP.basic.method.Varargs' cannot be applied to '()'
        // String test = varargs.failed_concat_note1();



        // Test3) note1_가변인자에서 메소드 오버로딩 조심하기_같은 타입의 매개변수를 앞서 사용했을 때,
        // Ambiguous method call. Both
        // failed_concat(String, String...)
        // in Varargs and
        // failed_concat(String...)
        // in Varargs match
        //System.out.println(varargs.failed_concat("a"));
        // System.out.println(varargs.failed_concat("+","a"));

    }
}

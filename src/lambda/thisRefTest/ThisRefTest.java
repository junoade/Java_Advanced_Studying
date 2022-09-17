package lambda.thisRefTest;

public class ThisRefTest {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.innerMethod();
    }
}

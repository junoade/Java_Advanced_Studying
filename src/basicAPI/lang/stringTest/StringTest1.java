package basicAPI.lang.stringTest;

public class StringTest1 {
    public static void main(String[] args) {
        String A = "ABC";
        String B = new String("ABC");
        //String someObject = new String("kimtaeng");

        System.out.println(A.equals(B)); // print 'true'
        System.out.println(A == B); // print 'false
    }
}

package Examples.July;

public class IncrementTest {
    public static void main(String[] args) {
        for(int i = 0; i<1000; i++){
            int n = 1;
            System.out.printf("%d, %d \n",n++,n++); // 1,2
        }
    }
}

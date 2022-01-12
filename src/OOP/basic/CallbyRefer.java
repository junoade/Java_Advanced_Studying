package OOP.basic;

public class CallbyRefer {
    public static void main(String[] args) {
        Data d = new Data();
        d.x = 10;

        System.out.println("변화 전 main() 의 : x 값 " + d.x);
        change(d);
        System.out.println("After change(d)");
        System.out.println("main() 의 : x 값 " + d.x);

    }
    static void change(Data d){ // call by reference
        d.x = 9999;
        System.out.println("change(), call by reference 의 x 값 : " + d.x);
    }
}

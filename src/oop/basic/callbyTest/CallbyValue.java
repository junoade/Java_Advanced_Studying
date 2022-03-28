package oop.basic.callbyTest;

public class CallbyValue {
    public static void main(String[] args) {
        Data d = new Data();
        d.x = 10;
        System.out.println("초기 main() 함수에서의 x값 :  " + d.x);

        change(d.x);

        System.out.println("After change() 메소드 실행 이후 x값 : " + d.x);

    }
    static void change(int x){
        x = 1000;
        System.out.println("change()에서의 x 값 : " + x);
    }
}

class Data { int x;}

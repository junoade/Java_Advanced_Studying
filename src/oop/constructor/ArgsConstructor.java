package oop.constructor;


/**
 * OOP 매개변수가 있는 생성자,
 * 이 때는 Default Constructor를 명시해야 한다.
 */
public class ArgsConstructor {
    int status;

    public ArgsConstructor(int status){
        this.status = status;
        System.out.println("ArgsConstructor, status : " + status);
    }

    public ArgsConstructor(){
        this.status = 99;
        System.out.println("ArgsConstructor, status : " + status);
    }

}

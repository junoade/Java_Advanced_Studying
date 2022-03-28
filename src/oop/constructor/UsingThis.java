package oop.constructor;

public class UsingThis {
    String name;
    String address;

    UsingThis(){
        this("user", "address");
    }

    /*------------------------------------------------------------------------------------------*/
    // 생성자 이름으로, 클래스 이름 대신 this를 사용
    // 한 생성자에서 다른 생성자를 호출할 땐,
    // 반드시 첫번째 라인에서만 호출 가능
    // -> 생성자 내에서 초기화 작업 중, this() 를 통해 다른 생성자를 호출하게 되면,
    // 호출된 생성자 내에 멤버 변수들을 초기화 하며, 이전의 초기화 작업과 의미가 퇴색되거나 혼동될 수 있기 때문.
    UsingThis(String name){
        this(name, "경기도 의정부시");
    }
    /*------------------------------------------------------------------------------------------*/

    UsingThis(String name, String address){
        this.name = name;
        this.address = address;
    }
}

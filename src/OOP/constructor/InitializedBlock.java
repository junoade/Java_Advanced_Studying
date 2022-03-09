package OOP.constructor;

/**
 * 초기화 블럭 initialization block
 * 클래스 초기화 블럭, 인스턴스 초기화 블럭이 있다.
 *
 * 쓰는 이유는
 * - 명시적 초기화, 생성자에서 다루기 힘든 복잡한 작업을 수행하거나, ( 조건문, 반복문, 예외처리 등)
 * - 특히 인스턴스 초기화 블럭의 경우 인스턴스 마다 공통적으로 수행해야하는 기능의 코드 중복성을 줄일 수 있다.
 */
public class InitializedBlock {
    String serialID;
    String color;
    int count;

    /* class initialization block */
    static {
        System.out.println("클래스 로딩 완료");
    }

    /* instance initialization block*/
    // 생성자 보다 우선됨
    // 기본값 -> 명시적 초기화 -> 인스턴스 초기화 블럭 -> 생성자
    {
        count++;
        System.out.printf("serialID : %s, color : %s, total_count : %d \n", serialID, color, count); // null
    }

    InitializedBlock(){
        this("white", "00000000");
    }

    InitializedBlock(String color, String serialID){
        this.serialID = serialID;
        this.color = color;
        System.out.printf("serialID : %s, color : %s, total_count : %d \n", this.serialID, this.color, count);
    }


}

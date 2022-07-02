package basicAPI.lang.cloneTest;

public class MemberShallowCloneTest2 {

    /* original 객체와 shallow copied 객체 사이에서 서로 같은 Family 인스턴스를 공유하고 있다고 하자 */
    public static void main(String[] args) throws CloneNotSupportedException {
        Family dad = new Family("myDad", "Dad");
        Member2 junho = new Member2(dad, "junoade", "junho", "1234", 26, true);
        Member2 hunho = junho.shallowCopy();

        /* step1) 원본-복제 객체간 공유하는 Family 인스턴스의 멤버 값 변경 */
        hunho.family.name = "notMyDad";
        System.out.println("원본-복제 객체간 공유하는 Family 인스턴스의 멤버 값 변경 ");
        System.out.printf("원본 객체 주소 : %s  원본 객체의 내용 %s\n", junho.hashCode(), junho);
        System.out.printf("복제 객체 주소 : %s  복제 객체의 내용 %s\n", hunho.hashCode(), hunho);

        /**
         * 원본-복제 객체간 공유하는 Family 인스턴스의 멤버 값 변경
         * 원본 객체 주소 : 1784662007  원본 객체의 내용 id : myDad, name : notMyDad, id : junoade, name : junho, pwd : 1234 , age : 26, adult : true
         * 복제 객체 주소 : 1783593083  복제 객체의 내용 id : myDad, name : notMyDad, id : junoade, name : junho, pwd : 1234 , age : 26, adult : true
         */

        /* 참조변수가 가르키는 인스턴스 자체를 변경 */
        Family mom = new Family("ourMom", "Mama");
        Member2 origin = new Member2(dad, "Origin0000", "IamOrigin", "1234", 26, true);
        Member2 copy = origin.shallowCopy();

        copy.family = new Family("otherMom", "OtherMama");
        System.out.println("참조하는 인스턴스 자체를 변경 시");
        System.out.printf("원본 객체 주소 : %s  원본 객체의 내용 %s\n", origin.hashCode(), origin);
        System.out.printf("복제 객체 주소 : %s  복제 객체의 내용 %s\n", copy.hashCode(), copy);

    }

}

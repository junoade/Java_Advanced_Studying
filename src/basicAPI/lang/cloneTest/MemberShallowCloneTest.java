package basicAPI.lang.cloneTest;


public class MemberShallowCloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Member member_original = new Member("junoade", "Junho Choi", "1234", 26, true);
        Member member_cloned = member_original.shallowCopy();

        /* 원본 객체에서 비밀번호 바꿔보기 */
        member_original.pwd = "2345";

        System.out.printf("원본 객체 주소 : %s  원본 객체의 내용 %s\n", member_original.hashCode(), member_original);
        System.out.printf("복제 객체 주소 : %s  복제 객체의 내용 %s\n", member_cloned.hashCode(), member_cloned);

        member_cloned.pwd = "9999";
        System.out.printf("원본 객체 주소 : %s  원본 객체의 내용 %s\n", member_original.hashCode(), member_original);
        System.out.printf("복제 객체 주소 : %s  복제 객체의 내용 %s\n", member_cloned.hashCode(), member_cloned);

        /* 이건 얉은 복사라기 보다는 포인터를 하나 늘린 것으로 봐야겠다.*/
        Member m1 = new Member("junoade", "Junho Choi", "1234", 26, true);
        Member m2 = m1;
        m1.name = "김멍멍";

        System.out.printf("원본 객체 주소 : %s  원본 객체의 내용 %s\n", m1.hashCode(), m1);
        System.out.printf("복제 객체 주소 : %s  복제 객체의 내용 %s\n", m2.hashCode(), m2);
    }
}

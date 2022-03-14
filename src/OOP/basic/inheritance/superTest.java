package OOP.basic.inheritance;

/**
 * super 조상 클래스의 인스턴스 멤버 지칭하여 자식 클래스의 인스턴스 멤버와 구별되도록
 * super() 조상 클래스의 생성자
 */
public class superTest {
    public static void main(String[] args){
        Parent p = new Parent();
        Child c = new Child();
        System.out.println("Parent's Last name : "+ p.lastName);
        System.out.println("Child's Last name : "+ c.lastName);


        /* -------------------------------------------------------------------------- */
        Point pt = new Point(1,2);
        Point pt2 = new Point3D(); // 참조변수 pt2 는 Point3D의 인스턴스를 가르키나, Point 클래스에 정의된 인스턴스 멤버만 접근 가능
        Point3D pt3 = new Point3D(1,2,3);

        System.out.println("Point's instance pt " + pt);
        System.out.println("Point's instance pt2 " + pt2);
        System.out.println("Point3D's instance pt " + pt3);

    }
}

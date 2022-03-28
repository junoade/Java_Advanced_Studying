package oop.basic.inheritance;

public class Point3D extends Point{
    int z;

    Point3D(int x, int y,int z){
        super(x,y); // 첫줄에서만, 조상 클래스의 인스턴스 멤버를 먼저 초기화하기 때문에
        this.z = z;
    }
    Point3D(){
        this(0,0,0);
    }

    @Override
    public String toString(){
        return super.toString() + " " + z;
    }
}

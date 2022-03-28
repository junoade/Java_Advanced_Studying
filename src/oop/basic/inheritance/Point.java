package oop.basic.inheritance;

public class Point {
    int x;
    int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    Point(){
        this(0,0);
    }

    @Override
    public String toString(){
        return String.format("%d %d", x, y);
    }
}

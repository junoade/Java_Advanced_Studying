package Whiteship_livestudy.week1;

public class SchoolTest {
    public static void main(String[] args) {
        Student junho = new Student("Junho", "Seoul", "1234", "dgu", "computer");
        System.out.println("현재 학생 이름 : " +  junho.getS_name());
        System.out.println("현재 학생 거주지 : " +  junho.getS_addr());
    }
}

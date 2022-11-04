package learnUtils;

import java.util.Arrays;

public class StudyingArrayCopys {
    static class Element {
        User user;
        Department dept;

        Element(User user, Department dept) {
            this.user = user;
            this.dept = dept;
        }

        @Override
        public String toString() {
            return "Element{" + user + ", " + dept + "}";
        }
    }

    static class User {
        String id;
        private String pwd;

        User(String id, String pwd) {
            this.id = id;
            this.pwd = pwd;
        }

        @Override
        public String toString() {
            return "User{" + this.id + ", " + this.pwd + "}";
        }
    }

    static class Department {
        String id;
        String name;
        String location;

        Department(String id, String name, String location) {
            this.id = id;
            this.name = name;
            this.location = location;
        }

        @Override
        public String toString() {
            return "Department{" + this.id + ", " + this.name + ", " + this.location + "}";
        }
    }

    public static void main(String[] args) {
        Element[] list = new Element[2];
        User userA = new User("abcd", "1234");
        User userB = new User("abcc", "12345");

        Department dept = new Department("dept123", "쭈쭈노상회", "의정부");
        list[0] = new Element(userA, dept);
        list[1] = new Element(userB, dept);

        System.out.println("복사 전");
        System.out.println("주소 : " + list);
        System.out.println(Arrays.toString(list));

        System.out.println("복사 후");
        Element[] newList = Arrays.copyOf(list, list.length);
        System.out.println("주소 : " + newList);
        System.out.println(Arrays.toString(newList));
        newList[0].dept.location = "노원구";

        System.out.println("값 변경 후");
        System.out.println(Arrays.toString(list));
        System.out.println(Arrays.toString(newList));

    }
}

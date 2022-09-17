package generics.wildcardTest;

import java.util.Arrays;

public class CourseUtil {
    /* 모든 대상 */
    public static void getCourseInfo(Course<?> course){
        getInfo(course);
    }

    /* Student 부터, HighStudent 까지 */
    public static void getStudentCourseInfo(Course<? extends Student> course){
        getInfo(course);
    }

    /* Woker 부터, Person 까지 */
    public static void getWorkerCourseInfo(Course<? super Worker> course){
        getInfo(course);
    }

    static void getInfo(Course<?> course){
        System.out.println(course.getName() + " 수강생 리스트 : "
                + Arrays.toString(course.getEnrollers()));
    }
}

package generics.wildcardTest;

public class CourseUtilTest {
    public static void main(String[] args) {
        Course<Person> forAll = testPersonData();
        Course<Worker> forWorker = testWorkerData();
        Course<Student> forStudent = testStudentData();
        Course<HighStudent> forHighStudent = testHighStudentData();

        /* 모든 타입에 대해 적용 가능 */
        System.out.println("Test 1 ");
        CourseUtil.getCourseInfo(forAll);
        CourseUtil.getCourseInfo(forWorker);
        CourseUtil.getCourseInfo(forStudent);
        CourseUtil.getCourseInfo(forHighStudent);

        /* ? super Worker */
        System.out.println("Test 2 ");
        CourseUtil.getWorkerCourseInfo(forAll);
        CourseUtil.getWorkerCourseInfo(forWorker);

        /* ? extends Student */
        System.out.println("Test 3 ");
        CourseUtil.getStudentCourseInfo(forStudent);
        CourseUtil.getStudentCourseInfo(forHighStudent);
        // CourseUtil.getStudentCourseInfo(forAll);

    }

    static Course<Person> testPersonData(){
        Course<Person> result = new Course<>("일반인과정", 5);
        result.add(new Person("일반인"));
        result.add(new Worker("직장인"));
        result.add(new Student("학생"));
        result.add(new HighStudent("고등학생"));
        return result;
    }

    static Course<Worker> testWorkerData(){
        Course<Worker> result = new Course<>("직장인과정", 5);
        result.add(new Worker("직장인"));
        return result;
    }

    static Course<Student> testStudentData(){
        Course<Student> result = new Course<>("학생과정", 5);
        result.add(new Student("학생"));
        result.add(new HighStudent("고등학생"));
        return result;
    }

    static Course<HighStudent> testHighStudentData(){
        Course<HighStudent> result = new Course<>("고등학생과정", 5);
        result.add(new HighStudent("고등학생"));
        return result;
    }
}

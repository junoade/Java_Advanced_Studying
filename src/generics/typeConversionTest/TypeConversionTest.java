package generics.typeConversionTest;

/**
 * 제네릭 타입간, 형변환 테스트
 * 220919
 */
public class TypeConversionTest {
    public static void main(String[] args){
        TypeConversionTest tests = new TypeConversionTest();
        tests.test01();
        tests.test02();
        tests.test03();
    }

    /**
     * 논 제네릭 타입 <-> 제네릭 타입간 형변환 : 가능
     * 다만 경고
     */
    public void test01() {
        Box box = null; // warning; Raw use of parameterized class 'Box'
        Box<Object> objBox = null;

        box = (Box) objBox; // Casting 'objBox' to 'Box' is redundant
        objBox = (Box<Object>)box; // Unchecked cast: 'generics.typeConversionTest.Box' to 'generics.typeConversionTest.Box<java.lang.Object>'
    }

    /**
     * 서로 대입된 타입(parameterized type) 간 형변환은? 불가능, 컴파일 에러
     * Inconvertible types; cannot cast 'generics.typeConversionTest.Box<java.lang.String>' to 'generics.typeConversionTest.Box<java.lang.Object>'
     */
    public void test02(){
        Box<Object> objBox = null;
        Box<String> strBox = null;
        // objBox = (Box<Object>) strBox;
        // strBox = (Box<String>) objBox;
    }

    /**
     * 형변환하려는 기존 제네릭 타입(여기선 String)을 포함할 수 있는 제네릭 타입(Object)으로 형변환하면, 가능
     */
    public void test03(){
        // Object의 자손 타입에 대한 인스턴스간 형변환
        Box<? extends Object> wildObjBox = null;
        wildObjBox = new Box<String>();

        // String 의 조상 객체 타입에 대한 인스턴스간 형변환
        Box<? super String> wildStrBox = null;
        wildStrBox = new Box<Object>();

        // Unchecked cast:
        Box<?> wildObjBox2 = null;
        Box<String> wildStrBox2 = (Box<String>) wildObjBox2;

    }

    /**
     * wild card가 사용된 제네릭 타입 간 형변환 가능
     */
    public void test04(){
        Box<? extends Object> objBox = new Box<>();
        Box<? extends String> strBox = new Box<>();

        // Unchecked cast 경고
        strBox = (Box<? extends String>) objBox;
        objBox = (Box<? extends Object>) strBox;
    }
}

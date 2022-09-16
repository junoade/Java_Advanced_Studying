package generics.methodTest01;

public class Test {
    public static void main(String[] args){

        /* 제네릭 메소드 쓰고, static 메소드, 간결 */
        Box<Integer> boxed_01 = GenericMethod01.boxing(100);
        Box<Character> boxed_03 = GenericMethod01.boxing('a');

        /* 제네릭 메소드를 안쓰고, 인스턴스 생성, 동일한 제네릭 타입 사용 */
        GenericMethod02<String> gm = new GenericMethod02<>();
        Box<String> boxed_02 = gm.boxing(String.valueOf(100));

        /* 제네릭 메소드 쓰고, 인스턴스 생성, 서로 다른 제네릭 타입 사용 가능 */
        GenericMethod02<String> gm2 = new GenericMethod02<>();
        Box<Integer> boxed_04 = gm2.boxing2(123);

        System.out.println(boxed_01.get());
        System.out.println(boxed_02.get());
        System.out.println(boxed_03.get());
        System.out.println(boxed_04.get());
    }
}

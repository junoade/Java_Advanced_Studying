package learnUtils;

import java.util.Arrays;

public class StudyingArrays {
    public static void testBoxedTypeArraySort() {
        Integer[] arr1 = new Integer[]{
                99, 123, 50, 20, 100, 1234, 1
        };
        String[] arr2 = new String[]{"X", "A", "D", "C", "Z"};
        Double[] arr3 = new Double[]{123.0, 10.0, 5.0, 14.0, 1.0};

        printSortedResult(arr1);
        printSortedResult(arr2);
        printSortedResult(arr3);
    }

    static <T> void printSortedResult(T[] list) {
        System.out.println("정렬 전 : " + Arrays.toString(list));
        Arrays.sort(list);
        System.out.println("정렬 후 : " + Arrays.toString(list));
    }

    public static void main(String[] args) {
        testBoxedTypeArraySort();
    }

}

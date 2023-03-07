package arrays;

public class VarArgs {
    public static void main(String[] args) {
        String[] strArr = {"100", "200", "300"};
        System.out.println(concatenate(", ", strArr));
    }

    static String concatenate(String delim, String ... args) {
        StringBuilder sb = new StringBuilder();
        for(String s : args) {
            sb.append(s).append(delim);
        }
        int trimFromIdx = sb.length() - delim.length();
        int trimToIdx = sb.length();
        sb.delete(trimFromIdx, trimToIdx);
        return sb.toString();
    }
}

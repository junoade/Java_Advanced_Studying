package refactor.methodChaining;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ToBe_02 {
    private final int MIN_LENGTH = 1;
    private final int MAX_LENGTH = 1000;
    private final String REGEX_MATCHES = "[a-z]*([a-z])\\1+[a-z]*";
    private final String REGEX_FIND = "([a-z])\\1+";
    String cryptogram;

    public String solution(String cryptogram) {
        this.cryptogram = cryptogram;
        return !isValidLength() ? this.cryptogram : convertToLowercase().reduceDupChars().cryptogram;
    }

    boolean isValidLength() {
        int len = cryptogram.length();
        return len >= MIN_LENGTH && len <= MAX_LENGTH;
    }

    ToBe_02 convertToLowercase() {
        this.cryptogram = cryptogram.toLowerCase();
        return this;
    }

    /**
     * 정규표현식으로 탐색
     */
    boolean hasDupChars(String cryptogram) {
        return cryptogram.matches(REGEX_MATCHES);
    }

    /**
     * 정규 표현식을 이용해 2개 이상의 중복 문자가 있는지 탐색
     * 중복 문자의 개수만큼 반복하며, 중복 문자를 제거해감
     */
    ToBe_02 reduceDupChars() {
        Pattern ptrn = Pattern.compile(REGEX_FIND);
        while (hasDupChars(cryptogram)) {
            StringBuffer sb = new StringBuffer();
            Matcher matcher = ptrn.matcher(cryptogram);
            while (matcher.find()) {
                matcher.appendReplacement(sb, "");
            }
            matcher.appendTail(sb);
            cryptogram = sb.toString();
        }
        return this;
    }

    public static void main(String[] args) {
        ToBe_02 t2 = new ToBe_02();
        System.out.println(t2.solution("ZZYYLLEZX"));
    }
}

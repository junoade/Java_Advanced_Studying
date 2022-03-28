package oop.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2022.03.27
 * Programmers_Level1_신규아이디
 * 객체지향으로 리팩토링
 * https://programmers.co.kr/learn/courses/30/lessons/72410
 */
public class Refactoring_pl_newID {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Refactoring_pl_newID temp = new Refactoring_pl_newID();
        System.out.println(temp.solution(br.readLine()));
    }

    public String solution(String new_id){

        /* Rule 관련*/
        String regexStep2 = "[^a-z0-9-_.]";
        String regexStep3 = "[.]{2,}";
        String regexStep4 = "^[.]|[.]$";

        String puncEmpty = "";
        String puncDot = ".";

        final int MAX_LENGTH = 16;
        final int MIN_LENGTH = 2;
        return new User(new_id)
                .Id_toLowerCase()
                .Id_omitByRule(regexStep2, puncEmpty)
                .Id_omitByRule(regexStep3, puncDot)
                .Id_omitByRule(regexStep4, puncEmpty)
                .checkEmpty()
                .Id_omitOverLength(MAX_LENGTH)
                .Id_IterUnderLength(MIN_LENGTH)
                .getId();

    }

}

class User{
    public String new_id;

    public User(String new_id){
        this.new_id = new_id;
    }

    /* step1 */
    public User Id_toLowerCase(){
        this.new_id = new_id.toLowerCase();
        return this;
    }

    /* step2,3,4 */
    public User Id_omitByRule(String regex, String punc){
        this.new_id = new_id.replaceAll(regex, punc);
        return this;
    }

    /* step 5 */
    public User checkEmpty(){
        if(new_id.length() == 0)
            new_id += 'a';
        return this;
    }

    /* step 6 */
    public User Id_omitOverLength(int length){
        if(new_id.length() >= length){
            this.new_id = new_id.substring(0,length-1);
            if(new_id.charAt(new_id.length()-1) == '.')
                this.new_id = new_id.substring(0,length-1);
        }
        return this;
    }

    /* step 7 */
    public User Id_IterUnderLength(int length){
        StringBuilder sb = new StringBuilder(new_id);
        while(sb.length() <= length){
            sb.append(sb.charAt(sb.length()-1));
        }
        new_id = sb.toString();
        return this;
    }
    public String getId(){
        return new_id;
    }
}

/* Programmers 에서는 static Class 를 활용하여 풀이한 방법도 있었다.*/
package day6;

import java.util.Arrays;

public class StringEx {
    public static void main(String[] args) {
        System.out.println("\"NHN\".charAt(1): " + "NHN".charAt(1));
        System.out.println("\"NHN\".compareTo(\"ACADEMY\"): " + "NHN".compareTo("ACADEMY"));
        // NHN 과 ACADEMY 중 비교 (대소비교)
        // 13인 이유는 13자리 차이나서 (A와 N 사이)
        // A 보다 N 이 커서 13이 나옴
        System.out.println("\"NHN\".compareTo(\"NHN\"): " + "NHN".compareTo("NHN"));
        System.out.println("\"ACADEMY\".compareTo(\"NHN\"): " + "ACADEMY".compareTo("NHN"));
        System.out.println("\"NHN\".concat(\"ACADEMY\"): " + "NHN".concat("ACADEMY"));
        System.out.println("\"NHN\".equals(\"ACADEMY\"): " + "NHN".equals("ACADEMY"));
        System.out.println("\"NHN\".equals(\"NHN\"): " + "NHN".equals("NHN"));
        System.out.println("\"NHN\".isEmpty(): " + "NHN".isEmpty());
        System.out.println("\"\".isEmpty(): " + "".isEmpty());
        System.out.println("\"NHN\".length(): " + "NHN".length());
        System.out.println("\"NHN\".toLowerCase(): " + "NHN".toLowerCase());
        System.out.println("\"nhn\".toUpperCase(): " + "nhn".toUpperCase());

        System.out.println();
        System.out.println("indexOf : " + "NHN ACADEMY".indexOf('H'));
        System.out.println("indexOf : " + "NHN ACADEMY".indexOf(" "));
        System.out.println("indexOf : " + "NHN ACADEMY".indexOf("MY"));
        System.out.println("replace : " + "NHN ACADEMY".replace("MY", "MY!"));
        System.out.println("split : " + Arrays.toString("car,bus,truck".split(",")));
        System.out.println("startsWith : " + "NHN ACADEMY".startsWith("NHN"));
        System.out.println("substring : " + "NHN ACADEMY".substring(1, 5));
        System.out.println("trime : " + " NHN ACADEMY ".trim());
        System.out.println("valueOf : " + String.valueOf(1)); //String
        // valueOf는 앞에 붙어있는 타입으로 바꾸는 것
        System.out.println(Integer.valueOf(1).getClass()); //Integer
    }
}

package com.nhnacademy.yujinpark.tdd;

public class StringUtils {
    public static boolean isPalindrome(String candidate){
        boolean result = false;

        String reverse = "";
        for (int i = candidate.length() - 1; i >= 0; i--) {
            reverse = reverse + candidate.charAt(i);
        }
        // char로 뽑아서 값만 비교하는게 가장 성능이 좋다

        if(candidate.equals(reverse)){
            result = true;
        }

        return result;
    }
}

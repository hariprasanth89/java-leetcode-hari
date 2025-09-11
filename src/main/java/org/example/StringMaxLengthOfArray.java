package org.example;

public class StringMaxLengthOfArray {
    public static String findMaxLength(String[] str) {
        if (str == null || str.length == 0) {
            return null;
        }
        String maxLength = str[0];
        for (int i = 1; i < str.length; i++) {
            if (str[i].length() > maxLength.length()) {
                maxLength = str[i];
            }
        }
        return maxLength;
    }

    public static String findMaxLength2(String[] str) {
        StringBuilder res = new StringBuilder();
        int maxLen = 0;
        for(String sValue: str){
            maxLen = Math.max(maxLen, sValue.length());
        }
//        for (int i = 0; i < maxLen; i++){
            for (String s : str){
                if(maxLen == s.length() ) {
                    res.append(s);
                }
            }
//        }
        return res.toString();
    }

    public static String findMaxLength3(String[] str) {
        StringBuilder res = new StringBuilder();
        int maxLen = 0;
        for(String sValue: str){
            maxLen = Math.max(maxLen, sValue.length());
        }
        for (int i = 0; i < maxLen; i++){
        for (String s : str){
            if(i < s.length() ) {
                res.append(s.charAt(i) +" ");
            }
        }
        res.append(" \n");
        }
        return res.toString();
    }


    public static void main(String[] args) {
//        String[] str = {"apple", "banana", "grape", "kiwi"};
//        String maxLength = findMaxLength(str);
//        System.out.println("The string with the maximum length is: " + maxLength);
        String[] str1 = {"hari", "String", "wow"};
        System.out.println(findMaxLength3(str1));
    }


}

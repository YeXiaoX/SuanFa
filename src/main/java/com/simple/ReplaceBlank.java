package com.simple;

/**
 * Created by Ivan on 2016/5/24.
 * 替换所有的空格为%20
 * 考察代码的完整性和健壮性
 */
public class ReplaceBlank {

    public static String replace(String hello) {
        System.out.println(System.currentTimeMillis());
        char hellos[] = hello.toCharArray();
        String result = "";
        for (int i = 0; i < hello.length(); i++) {
            if (hellos[i] == 32) {
                result += "%20";
            } else {
                result += hellos[i];
            }
        }
        System.out.println(System.currentTimeMillis());
        return result;
    }

    public static String replace1(String hello) {
        System.out.println(System.currentTimeMillis());
        int j = 0;
        for (int i = 0; i < hello.length(); i++) {
            if (hello.charAt(i) == 32) {
                j++;
            }
        }
        int size = hello.length()+j*2;
        int index=0;
        char results[] = new char[size];
        for (int i = 0; i < hello.length(); i++) {
            if (hello.charAt(i) == 32) {
                results[index]='%';
                index++;
                results[index]='2';
                index++;
                results[index]='0';
                index++;
            }else{
                results[index]=hello.charAt(i);
                index++;
            }
        }
        String result = new String(results);
        System.out.println(System.currentTimeMillis());
        return result;
    }

    public static void main(String args[]) {
        String hello = "hello  my world!";
        String result = replace1(hello);
        System.out.println(result);
//        System.out.println("ss"+"\b"+"ss");
//        System.out.println(" ".toCharArray()[0]);
    }

}

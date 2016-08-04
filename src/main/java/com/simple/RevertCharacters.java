package com.simple;

/**
 * Created by Ivan on 2016/7/12.
 * 反转字符串中的单词的顺序，但不反转每个单词的中字母的顺序
 * 知识迁移能力
 */
public class RevertCharacters {
    public static void revert(String aa){
        String aas[]=aa.split(" ");
        String result = "";
        for(int i=aas.length-1;i>=0;i--){
            if(i!=0) {
                result = result + aas[i] + " ";
            }else{
                result+=aas[i];
            }
        }
        System.out.println("revert:"+result);
    }

    public static void revertStr(String aa){
        char aas[]=aa.toCharArray();
        String temp="";
        for(int i=aas.length-1;i>=0;i--){
            temp+=aas[i];
        }
        System.out.println("temp:"+temp);
        String temps[]=temp.split(" ");
        String result="";
        for(int j=0;j<temps.length;j++){
            temps[j]=revertCharacter(temps[j]);
            if(j!=temps.length-1){
                result=result+temps[j]+" ";
            }else{
                result+=temps[j];
            }
        }
        System.out.println("revertStr:"+result);
    }

    public static String revertCharacter(String aa){
        char aas[]=aa.toCharArray();
        String temp="";
        for(int i=aas.length-1;i>=0;i--){
            temp+=aas[i];
        }
        return temp;
    }

    /*
    * 字符串的左旋，把字符串的前n个字符放到字符串的后面，如abcdefg和2,左旋后变为cdefgab
    * */
    public static void revertN(String aa,int n){
        if(aa.length()<n||n<0)return;
        String tempa=revertCharacter(aa);
        String temp1=tempa.substring(0,tempa.length()-n);
        String temp2=tempa.substring(tempa.length()-n,tempa.length());
        String result=revertCharacter(temp1)+revertCharacter(temp2);
        System.out.println("revertN:"+result);
    }

    public static void main(String args[]){
        String aa="I am a student.";
        revert(aa);
        revertStr(aa);
        String aa1="abcdefg";
        revertN(aa1,1);
    }
}

package com.simple;

/**
 * Created by Ivan on 2016/6/28.
 * 连续数组的最大和
 * 考察时间和空间效率
 */
public class TheBiggestSonArray {
    public static int getMax(int aa[]){
        int length=aa.length;
        if(length<1)return 0;
        int result = 0;
        int max = 0;
        for(int i=0;i<length;i++){
            if(result<=0){
                result = aa[i];
            }else{
                result=aa[i]+result;
            }
            if(result>max){
                max=result;
            }
        }
        return max;
    }

    public static void main(String args[]){
        int aa[]={1,-2,3,10,-4,7,-8,2,-5};
        System.out.println("the max:"+getMax(aa));
    }

}

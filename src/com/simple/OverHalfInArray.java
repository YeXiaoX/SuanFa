package com.simple;

/**
 * Created by Ivan on 2016/6/24.
 * 找出数组中出现次数超过一半的数字
 * 优化时间和空间效率
 */
public class OverHalfInArray {

   public static  class Temp {
        int a;
        int count;

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

    public static int findInt(int aa[]){
        Temp temp = new Temp();
        temp.setA(0);
        temp.setCount(0);
        for(int i=0;i< aa.length;i++){
            if(temp.getCount()==0){
                temp.setA(aa[i]);
                temp.setCount(1);
            }else if(temp.getCount()!=0&&temp.getA()==aa[i]){
                temp.setCount(temp.getCount()+1);
            }else{
                temp.setCount(temp.getCount()-1);
            }
        }
        return temp.getA();
    }

    public static void sort(int aa[],int start,int end,int length){

    }

    public static void main(String args[]){
        int aa[]={1,2};//,3,2,2,2,5,4,2};
        System.out.println("data:"+findInt(aa));
    }
}

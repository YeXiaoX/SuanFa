package com.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ivan on 2016/7/13.
 * N个骰子扔在地上，骰子的点数和为s，输入n，输出所有可能的s出现的概率
 * 考察抽象建模能力
 */
public class TheProbabilityOfN {
    public static Map<Integer,Integer> getProbability(int n,Map<Integer,Integer> map,int result){
        if(n==0){
            if(map.containsKey(result)){
                map.put(result,map.get(result)+1);
            }else{
                map.put(result,1);
            }
        }else {
            for (int i = 1; i < 7; i++) {
                int temp = i + result;
                getProbability(n - 1, map, temp);
            }
        }
        return map;
    }
    public static void main(String args[]){
        int n=10;
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        map = getProbability(n,map,0);
        int base = 1;
        for(int i=0;i<n;i++){
            base*=6;
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue()+"/"+base);
        }
    }
}

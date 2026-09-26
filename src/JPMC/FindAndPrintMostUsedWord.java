package JPMC;

import java.util.HashMap;
import java.util.Map;

public class FindAndPrintMostUsedWord {
    //write main method
    public static void findAndPrintMostUsedWord(String[] args){
        Map<String, Integer> argsM = new HashMap<>();
        for (String arg : args){
            argsM.merge(arg,1,Integer::sum);
        }

        String maxKey = "";
        int maxValue = Integer.MIN_VALUE;

        for (Map.Entry<String,Integer> entry : argsM.entrySet()){
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        System.out.println("maxKey="+maxKey+"  maxValue="+maxValue);
    }
    public static void main(String[] args) {
        String[] words =  {"a","b","c","a"};

        findAndPrintMostUsedWord(words);

    }
}

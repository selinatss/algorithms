import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GetRecursiveLetter {
    public static void main(String[] args){
        String sentence = "hello";
        getRecurringCharacter(sentence);
    }

    //Sonuçlar büyük harf
    //Büyük O ve küçük O aynı, input almalı
    public static void getRecurringCharacter(String sentence) {
        if(sentence == null){
            System.out.println("There aren't any recurring object");
        }
        sentence = sentence.toUpperCase();
        char[] charSentence = sentence.toCharArray();

        HashMap<Character, Integer> count = new HashMap<>();
        for(int i=0; i< charSentence.length; i++){
            if(!count.containsKey(charSentence[i])) {
                count.put(charSentence[i], 1);
            }else
            {
                count.put(charSentence[i], 2);
            }
        }

        /*Iterator<Map.Entry<Character, Integer>> iterator = count.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Character, Integer> entry = iterator.next();
            if(entry.getValue() > 1){
                System.out.println(entry.getKey().toString());
            }
        }*/
       count.entrySet().stream().filter(e -> e.getValue()>1).forEach(
                System.out::println
        );

    }

}

import java.util.HashMap;

//canConstrunct("a", "b") --> false
//canConstrunct("aa", "ab") --> false
//canConstrunct("aa", "aab") --> true
public class RansomNote {

    public static void main(String args[]){
        Boolean result = canConstrunct("aa", "aab");
        System.out.println(result);
    }

    public static boolean canConstrunct(String ransomNote, String magazine){
        HashMap<Character, Integer> count = new HashMap<>();

        for(char c: magazine.toCharArray()){
            count.put(c, count.getOrDefault(c, 0) + 1);
            System.out.println(c);
        }

        for(char c: ransomNote.toCharArray()) {
            if(!count.containsKey(c) || count.get(c) <=0){
                return false;
            }

            count.put(c, count.get(c) -1);
            System.out.println(count);
        }

        return true;
    }
}

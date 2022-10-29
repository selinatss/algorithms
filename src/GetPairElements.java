import java.util.*;

public class GetPairElements {
    public static void main(String[] args) {
        isValid("aabbggjjsss");
        int[] arr = {2,5,7,8,2,3,5,6,5};
        //getPairElements(arr);
        //System.out.println(alternatingCharacters("AABB"));

    }

    public static String isValid(String s) {
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int freq = charFreqMap.getOrDefault(c, 0);
            charFreqMap.put(c, ++freq);
        }

        int[] arr = new int[charFreqMap.size()];
        int idx = 0;
        for (Map.Entry<Character, Integer> characterIntegerEntry : charFreqMap.entrySet()) {
            arr[idx++] = characterIntegerEntry.getValue();
        }
        Arrays.sort(arr);

        if (charFreqMap.size() == 1) return "YES";

        int first = arr[0];
        int second = arr[1];
        int secondLast = arr[arr.length - 2];
        int last = arr[arr.length - 1];

        // If first and last are same, then all frequencies are same
        if (first == last) return "YES";

        // If first is 1, and all other characters have 1 frequency
        if (first == 1 && second == last) return "YES";

        // If all are same and last character has just 1 extra count
        if (first == second && second == secondLast && secondLast == (last - 1)) return "YES";

        // Else invalid string
        return "NO";
    }

    public static int alternatingCharacters(String s) {
        char[] alphabetList = s.toCharArray();
        List<Character> listC = new ArrayList<Character>();
        for (char c : alphabetList) {
            listC.add(c);
        }
        int count=0;
        if(alphabetList.length <=1)
            return count;

        for(int i= 0; i< listC.size()-1; i++){
            if(String.valueOf(listC.get(i)).equals(String.valueOf(listC.get(i+1)))){
                count++;
            }
        }
        return count;
    }

    public static void getPairElements(int[] arr){
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            Integer c = countMap.get(arr[i]);
            if(!countMap.containsKey(arr[i])){
                countMap.put(arr[i], 1);
            }else{
                countMap.put(arr[i], ++c);
            }
        }

        countMap.entrySet().stream().filter(e -> e.getValue() > 1).forEach(
                System.out::println
        );
    }
}

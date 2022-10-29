import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MinimumBribes {
    public static void main(String[] args){
         List<Integer> list = Arrays.asList(2,1,3,4,5,6,7,8,9,10);
         minimumBribes(list);
    }

    public static void minimumBribes(List<Integer> q){
        List<Integer> bribeCount = new ArrayList<>();
        int total = 0;
        for(int i = 0; i< q.size(); i++){
            int bribe = q.get(i)-(i+1);
            if(bribe > 0) {
                bribeCount.add(bribe);
                total += bribe;
            }
        }
        bribeCount = bribeCount.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        if(bribeCount.get(0) > 2){
            System.out.println("Too chaotic");
        }else {
            System.out.println(total);
        }

    }
}

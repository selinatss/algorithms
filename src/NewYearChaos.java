import java.util.ArrayList;
import java.util.List;

public class NewYearChaos {
    public static void main(String[] args){
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(5);
        arr.add(3);
        arr.add(7);
        arr.add(8);
        arr.add(6);
        arr.add(4);

        minimumBribes(arr);
    }


    public static void minimumBribes(List<Integer> q) {
        int bribe = 0;
        boolean chaotic = false;
        for(int i = 0; i< q.size(); i++){
            if(q.get(i) - (i+1) > 2){
                chaotic = true;
                break;
            }
            else if(q.get(i) > (i+1)){
                if((q.get(i) - (i+1)) < 3){
                    bribe += (q.get(i) - (i+1));
                }
            }
        }
        if(chaotic)
            System.out.println("Too chaotic");
        else if(bribe != 0)
            System.out.println(bribe);

    }


}

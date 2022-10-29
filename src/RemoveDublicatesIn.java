import java.util.Arrays;
import java.util.LinkedHashSet;

public class RemoveDublicatesIn {
    public static void main(String[] args) {
         int[] arr = {1,2,6,7,8,6,8,9,0,9,9,9};
         Arrays.sort(arr);
         int j = removeDublicates(arr, arr.length);
         LinkedHashSet<Integer> arr2 = removeDublicates2(arr, arr.length);
         arr2.forEach(System.out::println);
    }

    public static int removeDublicates(int[] array, int n){
        if(n == 0 || n == 1){
            return 1;
        }

        int[] temp = new int[n];
        int j = 0;

        for(int i = 0; i < n-1; i++){
            if(array[i] != array[i+1]){
                temp[j++] = array[i];
            }
        }

        temp[j++] = array[n-1];

        for(int i = 0; i < j; i++){
            array[i] = temp[i];
        }

        return j;

    }

    public static LinkedHashSet<Integer> removeDublicates2(int[] arr, int n){
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        for(int i=0; i < n; i++){
            linkedHashSet.add(arr[i]);
        }
        return linkedHashSet;
    }
}

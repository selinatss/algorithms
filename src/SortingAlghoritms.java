import java.util.*;

public class SortingAlghoritms {
    public static void main (String args[]){
        int arr[] = { 2, 3, 7, 6, 8, -1, -10, 15 };
        int arr_size = arr.length;

        int missing = findMissingNo(arr, arr_size);

        System.out.println( "The smallest positive"
                + " missing number is " + missing);
        //solution2(2);

        int[] inp = { 2, 3, 1, 4, 5 };
        int n = inp.length;

        int[] a = new int[(n + 1)/2];
        int[] b = new int[n - a.length];

        for (int i = 0; i < n; i++)
        {
            if (i < a.length)
                a[i] = inp[i];
            else
                b[i - a.length] = inp[i];
        }

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

        Arrays.sort(a);
        Arrays.sort(b);

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

        if(b[0] > a[1]){
            System.out.println(true);
        }

        String s = "|***|**|";
        List<Integer> arrr1 = new ArrayList<>();
        arrr1.add(1);
        arrr1.add(1);

        List<Integer> arrr2 = new ArrayList<>();
        arrr2.add(1);
        arrr2.add(5);
        numberOfItems(s,arrr1,arrr2);

        }

    public static void solution2(int N) {
        int a = 7736;
        ArrayList<Integer>  aa = new ArrayList<Integer>();
        while (a != 0) {
            System.out.println(a % 10);
            aa.add(a % 10);
            a = a / 10;
        }

        int temp = 0;

        Collections.reverse(aa);
        for(int i : aa){
            if(aa.get(i) > 5){
                temp = i;
                break;
            }

            System.out.println(temp);
        }

        aa.add(temp,5);
        System.out.println(aa);

    }
    public void sort(ArrayList<Integer> list) {
        Collections.sort(list);

        for(int i: list){
            System.out.println(list.get(i));
        }
    }

    public void onePassBubbleSort(ArrayList<Integer> list, int numSorted) {
        int size = list.size();

        for(int j = 0; j < size - numSorted - 1; ++j) {
            if (list.get(j) > list.get(j + 1)) {
                int temp = list.get(j);
                list.set(j, list.get(j + 1));
                list.set(j + 1, temp);
            }
        }
    }

    //Bubble Sort
    public void sortByMagnitudeWithBubbleSort(ArrayList<Integer> list) {
        for(int i = 0; i < list.size() - 1; ++i) {
            this.onePassBubbleSort(list, i);
            System.out.println(i + 1 + "step");
        }

    }

    public int getSmallestMagnitude(ArrayList<Integer> list, int from) {
        int minIdx = from;

        for(int i = from + 1; i < list.size(); ++i) {
            if (list.get(i) < list.get(minIdx)) {
                minIdx = i;
            }
        }
        return minIdx;
    }



    //Selection Sort
    public void sortByMagnitude(ArrayList<Integer> list) {
        for(int i = 0; i < list.size(); ++i) {
            int minIdx = this.getSmallestMagnitude(list, i);
            int qi = list.get(i);
            int qmin = list.get(minIdx);
            list.set(i, qmin);
            list.set(minIdx, qi);
            System.out.println(i + " step");
        }

    }

    static int findMissingNo(int []A, int n)
    {
        int max;

        int next;

        for (int i = 0; i < n; i++) {
            if (A[i] <= 0 || A[i] > n)
                continue;

            max = A[i];

            while (A[max - 1] != max) {
                next = A[max - 1];
                A[max - 1] = max;
                max = next;
                if (max <= 0 || max > n)
                    break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    public static long howManySwaps(List<Integer> arr) {
        long swap = 0;
        for(int i=0; i< arr.size(); i++) {
            if(arr.get(i) > arr.get(i+1)){
                int temp = arr.get(i);
                arr.set(i, arr.get(i+1));
                arr.set(i+1, temp);
                swap++;
            }
        }
        return swap;
    }


    public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
        int[] arr = new int[s.length()];
        int count = 0;
        for(int i =0 ; i < s.length(); ++i){
            if(s.charAt(i) == '|'){
                arr[i] = count;
            }else{
                count++;
            }
        }

        List<Integer> arrayList =  new ArrayList<>();
        for(int i = 0; i<startIndices.size(); i++){
            int start = startIndices.get(i) - 1;
            int end = endIndices.get(i) - 1;

            while(start < end && s.charAt(start) != '|')++start;
            while(start < end && s.charAt(end) != '|')--end;

            arrayList.add(arr[end] - arr[start]);
        }
        return arrayList;

    }




}

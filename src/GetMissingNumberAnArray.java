//How do you find the missing number in a given integer array of 1 to 100?

public class GetMissingNumberAnArray {
    public static void main(String args[]) {
        int a[] = {1,2,3,4,6};
        int miss = getMissingNumber(a, 5);
        System.out.println(miss);
    }
    private static int getMissingNumber(int[] arr, int n){
        int i,total;
        total = (n+1) * (n+2)/2;

        for(i = 0; i < n; i++) {
            total -= arr[i];
        }
        return total;
    }
}

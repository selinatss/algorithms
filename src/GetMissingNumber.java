public class GetMissingNumber {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5, 8,9,10};
        GetMissingNumber gmn = new GetMissingNumber();
        gmn.getMissingNumberInArray(array);
    }

    public int getMissingNumberInArray(int[] array){
        int n = array.length - 1;
        int sum = n*(n+1)/2;

        for (int i = 0; i< array.length; i++){
            sum -= array[i];
        }

        System.out.println(sum);
        return sum;
    }
}

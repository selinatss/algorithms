import java.util.HashMap;

class GFG {

    public static void main(String[] args) {
        int[] blocks = {2,6,8,5};
        System.out.println(getDistance(blocks));
    }


        public static int getDistance(int[] blocks){
            int ans= 0;
            for(int i=0; i<blocks.length; i++){
                int leftMax=i;
                int rightMax=i;

                while(leftMax-1 >= 0 && blocks[leftMax] <= blocks[leftMax-1]){
                    leftMax--;
                }
                while(rightMax+1 < blocks.length && blocks[rightMax] <= blocks[rightMax+1]){
                    rightMax++;
                }
                ans= Math.max(ans, rightMax - leftMax +1);
            }
            return ans;
        }

    static int digitSum(long n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10);
            n /= 10;
        }
        return sum;
    }


    static void findMax(int[] arr, int n) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int ans = -1, pairi = 0, pairj = 0;
        for (int i = 0; i < n; i++) {
            int sumOfNumber = digitSum(arr[i]);
            if (map.containsKey(sumOfNumber)) {
                if (arr[i] + map.get(sumOfNumber) > ans) {
                    pairi = arr[i];
                    pairj = map.get(sumOfNumber);
                    ans = pairi + pairj;
                }
                map.put(sumOfNumber, Math.max(arr[i], map.get(sumOfNumber)));
            } else
                map.put(sumOfNumber, arr[i]);
        }
    }

}
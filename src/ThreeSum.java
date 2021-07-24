//Given an array S of n integer, are there elements a, b, c in S such that a + b + c = 0 ? Find all unique triplets in the array which givesthe sum of zero

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.StreamSupport;

public class ThreeSum {
    public static void main(String args[]) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(thereeeSum(arr));
    }

      public static List<List<Integer>>  thereeeSum(int[] nums) {
          List<List<Integer>>  result = new ArrayList<>();
          Arrays.sort(nums);

          for(int i = 0; i < nums.length - 2; i++) {
              if(i>0 && nums[i] == nums[i-1]) {
                  continue;
              }

              int j = i + 1;
              int k = nums.length - 1;
              int target = -nums[i];

              while(j < k) {
                  if(nums[j] + nums[k] == target) {
                      ArrayList<Integer> temp = new ArrayList<Integer>();
                      temp.add(nums[i]);
                      temp.add(nums[j]);
                      temp.add(nums[k]);

                      result.add(temp);

                      j++;
                      k--;

                      while(j < k && nums[j] == nums[j - 1]) {
                          j++;
                      }

                      while(j < k && nums[k] == nums[k + 1]){
                          k--;
                      }
                  } else if(nums[j] + nums[k] > target) {
                      k--;
                  } else {
                      j++;
                  }
              }
          }

          return result;
      }
}

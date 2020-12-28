/*Alex works at a clothing store. There is a large pile of socks that must be paired by color for sale. Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.

For example, there are n=7 socks with colors ar=[1,2,2,1,1,3,2] . There is one pair of color  and one of color . There are three odd socks left, one of each color. The number of pairs is .

Function Description

Complete the sockMerchant function in the editor below. It must return an integer representing the number of matching pairs of socks that are available.

sockMerchant has the following parameter(s):

n: the number of socks in the pile
ar: the colors of each sock
Input Format

The first line contains an integer , the number of socks represented in .
The second line contains  space-separated integers describing the colors  of the socks in the pile. */


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SalesByMatch {

    public static void main(String args[]){
        int arr[] = new int[]{10,20,20,10,10,30,50,10,20};
        int n = 9;

        sockMerchant(n, arr);
    }

    static int sockMerchant(int n, int[] ar) {
        HashMap<Integer, Integer> sockColorCount = new HashMap<>();
        for(int i=0; i<n; i++){
            if(!sockColorCount.containsKey(ar[i]))
                sockColorCount.put(ar[i], 1);
            else
                sockColorCount.put(ar[i], sockColorCount.get(ar[i])+1);
        }

        int count = 0;
        Iterator it = sockColorCount.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            if((int)pair.getValue() > 1){
                count = count + (int)pair.getValue()/2;
            }
        }
        System.out.println(count);
        return count;
    }

}

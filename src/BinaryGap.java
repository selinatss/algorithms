import java.util.ArrayList;

/*
A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.

For example, number 9 has binary representation 1001 and contains a binary gap of length 2.
The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3.
The number 20 has binary representation 10100 and contains one binary gap of length 1.
The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.

Write a function:

class Solution { public int solution(int N); }

that, given a positive integer N, returns the length of its longest binary gap.
The function should return 0 if N doesn't contain a binary gap.

For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..2,147,483,647].

*/
public class BinaryGap {
    public static void main(String args []){
      String value = "red";

      String A = "23A84Q";
      String B  = "K2Q25J";

        solution(A, B);
        int[] intArray = new int[] {4, -1, 0, 3};
        int[] intArray2 = new int[] {-2, 6, 0, 4};

        solution2(intArray, intArray2);

     }

    public static int solution(String A, String B) {
        int result = 0;
        char[] aCards = A.toCharArray();
        char[] bCards = B.toCharArray();

        ArrayList<Integer> aCardList = arrangeCards(aCards);
        ArrayList<Integer> bCardList = arrangeCards(bCards);

        for(int i=0; i<aCardList.size(); i++){
            if(aCardList.get(i) > bCardList.get(i))
                result++;
        }



        return result;
    }

    private static ArrayList<Integer> arrangeCards(char[] cards) {
        ArrayList<Integer> cardList = new ArrayList<>();
        for(int i = 0; i< cards.length; i++){
            if(cards[i] == 'A')
                cardList.add(14);
            else if(cards[i] == 'K')
                cardList.add(13);
            else if(cards[i] == 'Q')
                cardList.add(12);
            else if(cards[i] == 'J')
                cardList.add(11);
            else if(cards[i] == 'T')
                cardList.add(10);
            else
                cardList.add(Character.getNumericValue(cards[i]));
        }

        return cardList;
    }

    public static int solution2 (int[] A, int[] B) {
        int result = 0;
        if(sumOfArray(A) == sumOfArray(B)){
            return result;
        }
        for (int i = 0; i< A.length; i++){
            A[i] = 0;
            B[i] = 0;
            if(sumOfArray(A) == sumOfArray(B)){
                result = i;
                break;
            }
        }

        return result;
    }

    public static int sumOfArray(int[] array){
        int result = 0;
        for(int i = 0; i< array.length; i++){
            result += array[i];
        }
        return result;
    }

    public int solution(int N) {
        String binaryString = Integer.toBinaryString(N);

        int longestBinaryGap = 0;
        ArrayList<Integer> onesList = new ArrayList();

        for(int i=0; i<binaryString.length(); i++) {
            if(binaryString.charAt(i) == '0') continue;
            onesList.add(i);
        }

        for(int i=0; i<onesList.size() - 1; i++) {
            //subtract 1 so that don't count 1's next to each other as having any gap
            int indicesDiff = onesList.get(i+1) - onesList.get(i) - 1;

            longestBinaryGap = Math.max(longestBinaryGap, indicesDiff);
        }
        return longestBinaryGap;
    }
}

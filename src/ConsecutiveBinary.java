public class ConsecutiveBinary {
    public static void main(String[] args) {

    }

    static int countSubstring(String S)
    {
        int ans = 0;
        int i = 0;
        int n = S.toCharArray().length;
        while (i < n) {
            int countOf0 = 0, countOf1 = 0;
            if (S.charAt(i) == '0') {
                while (i < n && S.charAt(i) == '0') {
                    countOf0++;
                    i++;
                }

                int j = i;
                while (j < n && S.charAt(j) == '1') {
                    countOf1++;
                    j++;
                }
            }
            else {
                while (i < n && S.charAt(i) == '1') {
                    countOf1++;
                    i++;
                }
                int j = i;
                while (j < n && S.charAt(j) == '0') {
                    countOf0++;
                    j++;
                }
            }
            ans += Math.min(countOf0, countOf1);
        }
        return ans;
    }

}

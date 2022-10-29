public class MinimumInsertion {
    public static void main(String[] args) {
          System.out.println(findMinInsertionsDP("abab"));
        //System.out.println(insertionCount("abab"));
    }

    static boolean isPalindrome(char []str)
    {
        int n = str.length;
        if (n == 1)
            return true;
        int first = 0;
        int  last = n-1;
        while (last >= first)
        {
            if (str[first] != str[last])
                return false;
            first++;
            last--;
        }
        return true;
    }

    static int insertionCount(String s)
    {
        if (isPalindrome(s.toCharArray()))
            return 0;
        s=s.substring(1);

        return 1 + insertionCount(s);
    }

    static int findMinInsertionsDP(String s)
    {
        char[] str = s.toCharArray();
        int n =  str.length;
        int table[][] = new int[n][n];
        int l, h, gap;

        for (gap = 1; gap < n; ++gap)
            for (l = 0, h = gap; h < n; ++l, ++h)
                table[l][h] = (str[l] == str[h])?
                        table[l+1][h-1] :
                        (Integer.min(table[l][h-1],
                                table[l+1][h]) + 1);

        return table[0][n-1];
    }
}

public class TwoStringAnagramOrNot {
    public static void main(String[] args){
        String s1 = "selin";
        String s2 = "selin";

        boolean ss = areAnagram(s1, s2);
        System.out.println(ss);
    }

    private static boolean areAnagram (String str1, String str2) {
        char[] str1Char = str1.toCharArray();
        char[] str2Char = str2.toCharArray();

        int length1 = str1Char.length;
        int length2 = str2Char.length;

        if(length1 != length2) {
            return false;
        }

        for(int i = 0; i < length1; i++){
            if(str1Char[i] != str2Char[i]){
                return false;
            }
        }

        return true;
    }
}

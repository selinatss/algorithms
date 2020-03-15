public class StringReverseWithRecursive {
    public static void main(String[] args) {
        String aa = "Hello Word!";
        StringReverseWithRecursive object = new StringReverseWithRecursive();
        object.reverse(aa);
    }
    private void reverse(String str){
        if((str == null) || (str.length() <= 1)){
            System.out.println(str);
        }else{
            System.out.println(str.charAt(str.length()-1));
            reverse(str.substring(0, str.length()-1));
        }
    }
}

public class MaskingAlgorithms {
    public static void main(String[] args) throws Exception{
        String account = "147852369852147";

        System.out.println(maskString(account, 1, 11, '*'));
    }

    private static String maskString(String text, int start, int end, char maskChar) throws Exception{
        if(text == null || text.equals("")) {
            return "";
        }

        if(start < 0) {
            start = 0;
        }

        if(end > text.length()){
            end = text.length();
        }

        int maskLength = end - start;
        if(maskLength == 0){
            return text;
        }
        StringBuilder sbMaskString = new StringBuilder();

        for(int i = 0; i < maskLength; i++) {
            sbMaskString.append(maskChar);
        }

        return text.substring(0,start)
                + sbMaskString.toString()
                + text.substring(start + maskLength);
    }


}

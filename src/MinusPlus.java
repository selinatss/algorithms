public class MinusPlus {
    public static void main(String[] args) {
        String ss = "minusplusminus";
        MinusPlus mp = new MinusPlus();
        mp.replaceMinusPlus(ss);
    }

    private void replaceMinusPlus(String ss){
        //minusPlus
        ss = ss.replaceAll("minus", "-").replaceAll("plus", "+");
        System.out.println(ss);
    }
}

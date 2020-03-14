public class BinaryDecimal {

    public static void main(String args[]){
        Integer decimal = convertBinaryToDecimal(101011);
        System.out.println(decimal);

        Integer binary = convertDecimalToBinary(43);
        System.out.println(binary);
    }

    public static Integer convertBinaryToDecimal(Integer binaryNumber) {

        Integer decimalNumber = 0;
        Integer base = 1;

        while (binaryNumber > 0) {
            int lastDigit = binaryNumber % 10;
            binaryNumber = binaryNumber / 10;
            decimalNumber += lastDigit * base;
            base = base * 2;
        }
        return decimalNumber;
    }

    public static Integer convertDecimalToBinary(Integer decimalNumber) {

        if (decimalNumber == 0) {
            return decimalNumber;
        }

        StringBuilder binaryNumber = new StringBuilder();
        Integer quotient = decimalNumber;

        while (quotient > 0) {
            int remainder = quotient % 2;
            binaryNumber.append(remainder);
            quotient /= 2;
        }

        binaryNumber = binaryNumber.reverse();
        return Integer.valueOf(binaryNumber.toString());
    }
}

package TextProcessing;

import java.math.BigInteger;
import java.util.*;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String a1 = input.nextLine();
        String a2 = input.nextLine();

        BigInteger num1 = new BigInteger(a1);
        BigInteger num2 = new BigInteger(a2);

        System.out.println(num1.multiply(num2));
    }
}

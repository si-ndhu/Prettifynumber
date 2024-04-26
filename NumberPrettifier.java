import java.math.BigDecimal;

public class NumberPrettifier {
    public static String prettifyNumber(double num) {
        BigDecimal bigNum = BigDecimal.valueOf(num);
        if (bigNum.abs().compareTo(BigDecimal.valueOf(1e6)) < 0) {
            if (bigNum.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0) {
                return String.valueOf((int) num); // Return integer if the number is an integer
            } else {
                return String.valueOf(bigNum); // Return the original number if it has a fractional part
            }
        } 
        else if (bigNum.abs().compareTo(BigDecimal.valueOf(1e9)) < 0) {
            return formatWithDecimalIfNeeded(bigNum, 1e6, "M");
        } else if (bigNum.abs().compareTo(BigDecimal.valueOf(1e12)) < 0) {
            return formatWithDecimalIfNeeded(bigNum, 1e9, "B");
        } else {
            return formatWithDecimalIfNeeded(bigNum, 1e12, "T");
        }
    }
    
    private static String formatWithDecimalIfNeeded(BigDecimal num, double threshold, String suffix) {
        BigDecimal scaledNum = num.divide(BigDecimal.valueOf(threshold));
        if (scaledNum.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0) {
            return String.format("%.0f%s", scaledNum, suffix);
        } else {
            return String.format("%.1f%s", scaledNum, suffix);
        }
    }

    public static void main(String[] args) {
        System.out.println(prettifyNumber(1000000));       // Output: 1M
        System.out.println(prettifyNumber(2500000.34));    // Output: 2.5M
        System.out.println(prettifyNumber(532));           // Output: 532
        System.out.println(prettifyNumber(1123456789));    // Output: 1.1B
        System.out.println(prettifyNumber(1000000000000.0));  // Output: 1T
    }
}

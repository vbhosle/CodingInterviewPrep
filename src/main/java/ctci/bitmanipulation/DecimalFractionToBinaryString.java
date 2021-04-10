package ctci.bitmanipulation;

public class DecimalFractionToBinaryString {
    public static String toString(double number) {
        if(number >= 1 || number <= 0)
            return "ERROR";

        StringBuilder sb = new StringBuilder();
        sb.append(".");

        while(number > 0.0) {
            if((sb.length() - 1) > 32)
                return "ERROR";
            number *= 2;
            if(number >= 1) {
                sb.append(1);
                number = number - 1;
            }
            else {
                sb.append(0);
            }
        }

        return sb.toString();
    }
}

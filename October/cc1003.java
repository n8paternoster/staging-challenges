package October;

import java.util.regex.*;  

public class cc1003 {
    /**
     *  (1) Valid pin
     *  Valid pin is 4 or 6 characters, 0-9 only, no spaces
     *  Using regex
     */
    static boolean isValidPin(String input) {
        return Pattern.matches("[0-9]{4}|[0-9]{6}", input);
    }

    /**
     *  (2) Factorial
     */
    static boolean isFactorial(int input) {
        if (input <= 0) return false;
        int factor = 2;
        while (input > 1) {
            if (input % factor != 0) return false;
            input /= factor++;
        }
        return true;
    }

    public static void main(String[] args) {
        String p1Inputs[] = {"121317", "1234", "45135", "89abc1", "900876", " 4983", ""};
        for (String i : p1Inputs)
            System.out.println("\"" + i + "\" = " + isValidPin(i));
        int p2Inputs[] = {0, 1, 2, 3, 27, 24, -2};
        for (int i : p2Inputs)
            System.out.println(i + " = " + isFactorial(i));
    }
}
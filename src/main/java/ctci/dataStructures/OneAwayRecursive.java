package ctci.dataStructures;

public class OneAwayRecursive {
        /**
         * @param s: a string
         * @param t: a string
         * @return: true if they are both one edit distance apart or false
         */
        public static boolean isOneEditDistance(String s, String t) {

            if(s.length() < t.length()) {
                String temp = s;
                s = t;
                t = temp;
            }
            if(s.length() - t.length() >= 2)
                return false;
            return isOneEditDistance(s, 0, t, 0, 0);
        }

        static boolean isOneEditDistance(String s, int si, String t, int ti, int count) {
            if(si >= s.length() && ti >= t.length())
                return count == 1;
            else if(si >= s.length() || ti >= t.length())
                return count == 0;
            else if(s.charAt(si) == t.charAt(ti))
                return isOneEditDistance(s, si+1, t, ti+1, count);
            else if(count == 1)
                return false;
            else
                return isOneEditDistance(s, si+1, t, ti, count+1) || isOneEditDistance(s, si+1, t, ti+1, count+1);

        }

    public static void main(String[] args) {
        String[][] tests = {{"a", "b", "true"},
                {"", "d", "true"},
                {"d", "de", "true"},
                {"pale", "pse", "false"},
                {"acdsfdsfadsf", "acdsgdsfadsf", "true"},
                {"acdsfdsfadsf", "acdsfdfadsf", "true"},
                {"acdsfdsfadsf", "acdsfdsfads", "true"},
                {"acdsfdsfadsf", "cdsfdsfadsf", "true"},
                {"adfdsfadsf", "acdfdsfdsf", "false"},
                {"adfdsfadsf", "bdfdsfadsg", "false"},
                {"adfdsfadsf", "affdsfads", "false"},
                {"pale", "pkle", "true"},
                {"pkle", "pable", "false"},
                {"pale", "pale", "false"}};
        for (int i = 0; i < tests.length; i++) {
            String[] test = tests[i];
            String a = test[0];
            String b = test[1];
            boolean expected = test[2].equals("true");

            test(a, b, expected);
            test(b, a, expected);
        }

    }

    public static void test(String a, String b, boolean expected) {
        boolean result = isOneEditDistance(a, b);

        if (result == expected) {
            System.out.println(a + ", " + b + ": success");
        } else {
            System.out.println(a + ", " + b + ": error");
        }
    }
}

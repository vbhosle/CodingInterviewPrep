package ctci.bitmanipulation;

// Why this doesn't pass all cases??
//https://www.codingninjas.com/codestudio/problems/bit-insertion_1171188
public class Insertion {
    public static int bitInsertion(int x, int y, int a, int b) {
        System.out.println("x = " + Integer.toBinaryString(x));
        System.out.println("y= " + Integer.toBinaryString(y));
        y = y << a;
        for(int pos = a; pos <= b; pos++) {
            x = setBit(x, y, pos);
        }

        return x;
    }

    private static int setBit(int x, int y, int pos) {
        int value = isBit1(y, pos) ? 1 : 0;
        return (x & ~(1 << pos)) | (value << pos);
    }

    private static boolean isBit1(int n, int pos) {
        return (n & (1 << pos)) != 0;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(bitInsertion(1, 8, 5, 15)));
        System.out.println(Integer.toBinaryString(bitInsertion(7, 21, 11, 30)));
        System.out.println(Integer.toBinaryString(bitInsertion(12143435, 564, 1, 10)));
        System.out.println(Integer.toBinaryString(bitInsertion(21321454 ,129, 11, 30)));
        System.out.println(Integer.toBinaryString(~0));
        System.out.println(Integer.toBinaryString((~0 << 2)));
        System.out.println(Integer.toBinaryString((1 << 2)));
    }
}

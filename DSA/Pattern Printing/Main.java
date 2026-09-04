import java.util.Scanner;
public class Main {
    static int n = 5;

    public static void PatternA() {
        for (int row = 1; row <= n; row++) {

            for (int col = 1; col <= n; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void PatternB() {
        for (int row = 1; row <= n; row++) {

            for (int col = 1; col <= n; col++) {
                System.out.print(row+ " ");
            }
            System.out.println();
        }
    }
    public static void PatternC() {
        for (int row = 1; row <= n; row++) {

            for (int col = 1; col <= row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void PatternD() {
        for (int row = 1; row <= n; row++) {

            for (int col = 1; col <= row; col++) {
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }
    public static void PatternDesh() {
        int value = 1;
        for (int row = 1; row <= n; row++) {
            int printValue= row%2==0 ? 0:1;
            for (int col = 1; col <= row; col++) {
                System.out.print(printValue+" ");
            }
            System.out.println();
        }
    }
    public static void PatternE() {
        int printVal;
        for (int row = 1; row <= n; row++) {
            printVal = row % 2 == 0 ? 0 : 1;
            for (int col = 1; col <= row; col++) {
                System.out.print(printVal + " ");
                printVal = printVal == 0 ? 1 : 0;
            }
            System.out.println();
        }
    }
    public static void PatternF() {
        int printValue = 1;
        for (int row = 1; row <= n; row++) {

            for (int col = 1; col <= row; col++) {
                System.out.print(printValue++ +" ");
            }
            System.out.println();
        }
    }
    public static void PatternG() {
        for (int row = 1; row <= n; row++) {

            for (int col = 1; col <= n-row+1; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void PatternH() {
        for (int row = 1; row <= n; row++) {

            for (int col = 1; col <= n-row+1; col++) {
                System.out.print(n-row+1);
            }
            System.out.println();
        }
    }
    public static void PatternI() {
        for (int row = 1; row <= n; row++) {

            for (int col = 1; col <= n-row+1; col++) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    public static void PatternJ() {
        for (int row = 1; row <= (2 * n) - 1; row++) {
            int colTimes = row > n ? (2 * n) - row : row;
            for (int col = 1; col <= colTimes; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void PatternK() {
        for (int row = 1; row <= n; row++) {
            int colTimes = row;
            for(int space =1; space<=n-colTimes;space++){
                System.out.print(" ");
            }
            for (int col = 1; col <= colTimes; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void PatternL() {
        for (int row = 1; row <= n; row++) {
            int colTimes = n-row+1;
            for(int space =1; space<=n-colTimes+1;space++){
                System.out.print(" ");
            }
            for (int col = 1; col <= colTimes; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void PatternM() {
        for (int row = 1; row <= n; row++) {
            int colTimes = row;
            for(int space =1; space<=n-colTimes;space++){
                System.out.print(" ");
            }
            for (int col = 1; col <= 2*row-1; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void PatternN() {
        for (int row = 1; row <= n; row++) {
            int colTimes = n-row+1;
            for(int space =1; space<=n-colTimes+1;space++){
                System.out.print(" ");
            }
            for (int col = 1; col <= 2*n-(2*row-1); col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void PatternO() {
        for (int row = 1; row <= (2 * n) - 1; row++) {
            int colTimes = row > n ? (2 * n) - row : row;
            for (int i = 1; i <= n-colTimes; i++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= colTimes*2-1; col++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

public static void main(String[] args){
        PatternO();
}
}

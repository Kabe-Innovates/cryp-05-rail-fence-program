import java.util.Scanner;

public class RailFenceCipher {

    public static void main(String[] args) {
        int i, j, len, rails, count;
        int[][] code = new int[100][1000];

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a Secret Message");
        String str = sc.nextLine();

        len = str.length();

        System.out.println("Enter number of rails");
        rails = sc.nextInt();

        // Initialize the matrix with 0
        for (i = 0; i < rails; i++) {
            for (j = 0; j < len; j++) {
                code[i][j] = 0;
            }
        }

        count = 0;
        j = 0;

        while (j < len) {
            if (count % 2 == 0) {
                // Downward direction
                for (i = 0; i < rails && j < len; i++) {
                    code[i][j] = str.charAt(j);
                    j++;
                }
            } else {
                // Upward direction (excluding first and last rail)
                for (i = rails - 2; i > 0 && j < len; i--) {
                    code[i][j] = str.charAt(j);
                    j++;
                }
            }
            count++;
        }

        // Print encrypted message
        for (i = 0; i < rails; i++) {
            for (j = 0; j < len; j++) {
                if (code[i][j] != 0) {
                    System.out.print((char) code[i][j]);
                }
            }
        }

        System.out.println();
        sc.close();
    }
}


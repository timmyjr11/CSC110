import java.util.InputMismatchException;
import java.util.Scanner;

public class Pyramid {
    public static void main(String[] args) {
        // Create scanner and prompt user for input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows between 1 and 15: ");
        int lines;

        // While loop used to gain input with error correction
        while (true) {

            /* Attempt to gain value. Exits while loop if correct
            Otherwise, tell user it's incorrect and try again */
            try {
                lines = sc.nextInt();
                if (lines > 15 || lines < 1) throw new InputMismatchException();
                sc.close();
                break;

            } catch (InputMismatchException e) {
                System.out.print("Invalid input, please put a whole number between 1 and 15: ");
                sc.nextLine();
            }
        }

        // Nested triple for-loop to build Pyramid
        for (int i = 1; i <= lines; i++) {

            // Handles spacing for proper shape
            for (int j = lines; j >= i + 1; j--) System.out.print("    ");

            // Handles left side, from value of line to one
            for (int x = i; x > 0; x--) System.out.printf("%-4d", x);

            // Handles right side, from 2 to value of line
            for (int k = 2; k <= i; k++) System.out.printf("%-4d", k);

            // Creates new row to create the shape of pyramid
            System.out.println();
        }
        // Exits, yippee!
        System.exit(0);
    }
}
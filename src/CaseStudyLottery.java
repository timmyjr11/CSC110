import java.util.*;

public class CaseStudyLottery {
    public static void main(String[] args) {
        // Generate a lottery number
        int matchSingle = 0, matches = 0, lottery = (int) (Math.random() * 1000);
        if (lottery < 100) lottery += 100;

        // Collect guess
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your lottery pick (Three digits): ");
        int guess = input.nextInt();

        // Get digits from lottery and make a list
        int lotteryDigit1 = lottery / 100, lotteryDigit2 = (lottery % 100) / 10, lotteryDigit3 = lottery % 10;
        List<Integer> lotteryDigits = new ArrayList<>(Arrays.asList(lotteryDigit1, lotteryDigit2, lotteryDigit3));


        // Get digits from guess and make a list
        int guessDigit1 = guess / 100, guessDigit2 = (guess % 100) / 10, guessDigit3 = guess % 10;
        List<Integer> guessDigits = new ArrayList<>(Arrays.asList(guessDigit1, guessDigit2, guessDigit3));

        System.out.println("The lottery number is " + lottery);

        // If matches, they win
        if (guess == lottery) System.out.println("Exact match: you win $10,000");
        else {
            // Create a temp list to use for checking duplicates
            List<Integer> temp = new ArrayList<>(Arrays.asList(lotteryDigit1, lotteryDigit2, lotteryDigit3));

            // For loop to go through each value
            for (int i = 0; i < guessDigits.size(); i++) {

                // Double if statement for checking exact and general matches,
                // then removing general match to prevent duplicate matches
                if (Objects.equals(guessDigits.get(i), lotteryDigits.get(i))) matchSingle++;

                if (temp.contains(guessDigits.get(i))) {
                    temp.remove(guessDigits.get(i));
                    matches++;
                }
            }

            // Tell user their outcome
            if (matches == 3) System.out.println("Matching digits: you win $3000");
            else if (matchSingle == 1) System.out.println("Match one digit: you win $500");
            else System.out.println("Sorry, no match.");
        }
        System.exit(0);
    }
}
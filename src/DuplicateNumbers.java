import java.util.*;

public class DuplicateNumbers {
    public static void main(String[] args) {
        // Declare scanner, number array, and string array
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[10];
        String[] numArray;

        // While loop used for try-catch loop
        while (true) {
            try {
                // Prompt user for 10 numbers,
                // then trim whitespace and create an array of numbers
                System.out.println("Enter 10 numbers (ex 1 2 3... 10): ");
                numArray = sc.nextLine().trim().split(" ");

                // Throw Exception if array is not length of 10
                if (numArray.length != 10) throw new Exception();

                // Parse string values to ints for the number array
                for (int i = 0; i < numArray.length; i++) nums[i] = Integer.parseInt(numArray[i]);

                // Print statement that gives all distinct numbers and call eliminateDuplicates
                System.out.println("The distinct numbers are: " + Arrays.toString(eliminateDuplicates(nums)));
                System.exit(0);

            // Catch any exception that may be thrown, and prompt the user to try again
            } catch (Exception e) {
                System.out.println("Invalid input, please try again.");
                sc.reset();
            }
        }
    }

    public static int[] eliminateDuplicates(int[] list) {
        // Create a linked hash set to ensure unique values in user-given order
        // then assign values of list to set to evaluate
        Set<Integer> set = new LinkedHashSet<>();
        for (int i : list) set.add(i);

        // Create an ArrayList to interact with original list,
        // Passing the values of the set
        List<Integer> tempList = new ArrayList<>(set);

        // Re-point list to a new array with the size of tempList
        // Then assign the values from tempList to list for return
        list = new int[tempList.size()];
        for (int i = 0; i < set.size(); i++) list[i] = tempList.get(i);
        return list;
    }
}

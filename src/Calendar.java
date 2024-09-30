import java.util.*;

public class Calendar {
    public static void main(String[] args) {
        // Declare scanner and month for input
        Scanner input = new Scanner(System.in);
        String month;
        int year;

        // Two lists to use for input verification
        List<Integer> monthInts = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
        List<String> monthStrings = new ArrayList<>(Arrays.asList(
                "january", "february", "march", "april","may", "june", "july",
                "august", "september", "october", "november", "december"));

        // try nested with a while loop to ensure program cannot fail with bad input
        while (true) {
            try {
                // Prompt user for year
                System.out.print("Enter year (Ex. 2024): ");
                year = input.nextInt();

                // Prompt user for month in either number or name, then remove whitespace and lowercase
                System.out.print("Enter month as a number (1 - 12) or a name (Ex. May or may): ");
                month = input.next();
                month = month.strip();
                month = month.toLowerCase();

                // If month is named, capitalize first letter and run printMonth
                // Use list monthStrings to verify name
                if(monthStrings.contains(month)) {
                    month = month.substring(0, 1).toUpperCase() + month.substring(1);
                    printMonth(year, month);
                }

                // If month is number, run printMonth
                // Use list monthInts to verify number
                else if(monthInts.contains(Integer.parseInt(month))) printMonth(year, Integer.parseInt(month));

                // Throw exception if failure to verify
                else throw new InputMismatchException();

                // Close scanner and exit
                input.close();
                System.exit(0);

                // If input invalid, then re-prompt the user
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Invalid input, please try again.");
                input.nextLine();
            }
        }
    }

    // Int version: Used to call and print the calendar title and body
    public static void printMonth(int year, int month) {
        printMonthTitle(year, month);
        printMonthBody(year, month);
    }

    // String version: Used to call methods to print the calendar title and body
    public static void printMonth(int year, String month) {
        printMonthTitle(year, month);
        printMonthBody(year, month);
    }

    // Int version: Used to print the title of calendar
    public static void printMonthTitle(int year, int month) {
        System.out.println("        " + getMonth(month) + " " + year);
        System.out.println("     -------------------");
        System.out.println("     Mon Tue Wed Thu Fri    ");
    }

    // String Version: Used to print the title of calendar
    public static void printMonthTitle(int year, String month) {
        System.out.println("        " + month + " " + year);
        System.out.println("     -------------------");
        System.out.println("     Mon Tue Wed Thu Fri    ");
    }

    // String version: Used to convert month name to month number, returns via return switch
    public static int getMonth(String month) {
        return switch (month) {
            case "January" -> 1;
            case "February" -> 2;
            case "March" -> 3;
            case "April" -> 4;
            case "May" -> 5;
            case "June" -> 6;
            case "July" -> 7;
            case "August" -> 8;
            case "September" -> 9;
            case "October" -> 10;
            case "November" -> 11;
            case "December" -> 12;
            default -> throw new InputMismatchException();
        };
    }

    // Int version: Used to convert month number to month name, returns via return switch
    public static String getMonth(int month) {
        return switch (month) {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> throw new InputMismatchException();
        };
    }

    // String version: Converts month name to month number and calls the int version
    public static void printMonthBody(int year, String month) {
        int monthNum = getMonth(month);
        printMonthBody(year, monthNum);
    }

    // Int version: Prints the month body, from Monday to Friday
    public static void printMonthBody(int year, int month) {

        // Call getStartDay to get the starting day
        int startDay = getStartDay(year,month);

        // Call getNumberofDaysInMonth to get total number of days in a given month
        int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);

        // Used in for loops
        int i;

        // Blank spacing for Saturday and Sunday
        for(i = 0; i < startDay; i++) System.out.print("    ");

        // Prints day of the month according to the number of days in given month
        for (i = 1; i <= numberOfDaysInMonth; i++) {

            if((i + startDay) % 7 ==  1/7 || (i + startDay + 6) % 7 == 0) System.out.print("    ");
            else System.out.printf("%4d", i);

            if((i + startDay) % 7 == 0) System.out.println();
        }
        System.out.println();
    }

    // Collects the starting day to print based on year and month
    public static int getStartDay(int year, int month) {
        // Constant used to initialize the start of computer calendar
        final int START_DAY_FOR_JAN_1_1800 = 3;

        // Get total number of days relative to 1/1/1800 to given date
        int totalNumberOfDays = getTotalNumberOfDays(year, month);

        // Returns the starting day of the month
        return (totalNumberOfDays + START_DAY_FOR_JAN_1_1800) % 7;
    }

    // Gets total number of days, used to calculate and match numbered days to days of the week
    public static int getTotalNumberOfDays(int year, int month) {
        int total = 0;

        // Goes from 1800 to current year to collect days, accounts for leap years
        for (int i = 1800; i < year; i++) {
            if(isLeapYear(i)) total = total + 366;
            else total = total + 365;
        }

        // Calculates the total days based on months given inside the current year
        for (int i = 1; i < month; i++) total = total + getNumberOfDaysInMonth(year, i);

        // Returns the total number of days using years and months
        return total;
    }

    // Gets the number of days in a given month
    public static int getNumberOfDaysInMonth(int year, int month) {

        // Two lists used to determine how many days in a given month
        List<Integer> monthEndInOne = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 8, 10, 12));
        List<Integer> monthEndInZero = new ArrayList<>(Arrays.asList(4, 6, 9 ,11));

        // If statements used to return the number of days to given month, accounts for leap year
        if(monthEndInOne.contains(month)) return 31;
        else if (monthEndInZero.contains(month)) return 30;
        else if (month == 2) return isLeapYear(year) ? 29 : 28;
        else throw new IllegalArgumentException("Invalid month: " + month);
    }

    // Boolean method used to determine if given year is a leap year
    public static boolean isLeapYear(int year) { return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0); }
}

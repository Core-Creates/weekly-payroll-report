/*
 * Author: Corrina Alcoser, Julio Vedoy, Billy Shelton
 * 
 */
import java.util.Calendar;
import java.util.Scanner;

// Beginning of Class AlcoserC004PA2********************************************************************
public class AlcoserC004PA2 {

    // input: Scanner object - Actual code: Page 3 of PA instructions
    private static Scanner input = new Scanner(System.in);

    // Beginning of Main ***********************************************************************
    public static void main(String[] args) {

        // Beginning of local (method-level) variables ************************************
        String first = "";
        String last = "";

        // payRate, grossPay, empl401k, percent401k, grossPayAllEmpl, total401kAllEmpl: double
        double payRate = 0.0;
        double grossPay = 0.0;
        double empl401k = 0.0;
        double percent401k = 0.0;
        double grossPayAllEmpl = 0.0;
        double total401kAllEmpl = 0.0;

        // hoursWorked, trigger: int initialize trigger to 1
        int hoursWorked = 1;
        int trigger = 1;

        // cont: char initialize to 'y'
        char cont = 'y';

        // dateTime: Calendar // Actual Code: Appendix 1, bottom page 1_8
        Calendar dateTime = Calendar.getInstance();

        // payrollExpense: String // Actual Code: Page 4 of PA instructions
        String payrollExpense = String.format("WEEKLY HOURLY EMPLOYEE PAYROLL" +
                "%n%nDate: %tD" + "%nTime: %tr" +
                "%n%n%56S %23s", dateTime, dateTime,
                "GROSS PAY", "401k");

        // Ending of local variable declaration ********************************************

        // 1st Prompt: "WEEKLY HOURLY PAYROLL SYSTEM"
        System.out.println("WEEKLY HOURLY PAYROLL SYSTEM");

        // 1st Prompt: "Continue? Enter 'Y' or 'N':"
        System.out.println("Continue? Enter 'Y' or 'N': ");
        // grabs next char keystroke and stores in cont
        cont = input.next().charAt(0);

        // Beginning of if for cont is n **************************************************
        if (cont == 'n' || cont == 'N') {
            // Print: "Exiting Weekly Hourly Payroll System."
            System.out.println("Exiting Weekly Hourly Payroll System.");
            // Exit program
            System.exit(0);
        }

        // Beginning of while cont is y ***************************************************
        while (cont == 'y' || cont == 'Y') {
            // 2nd Prompt: "Enter the employee's first name press enter then the last name press enter:"
            System.out.print("Enter the employee's first name press enter ");

            // Read first name
            first = input.nextLine();
            // Read last name
            System.out.print("then the last name press enter: ");
            last = input.nextLine();

            // 3rd Prompt: "Enter the number of hours worked for [first]:"
            System.out.printf("%nEnter the number of hours worked for %s: ", first);

            // Calls validateIntegers() with hoursWorked=validateIntegers(), the input.hasNextInt() grabs the next int typed in
            hoursWorked = validateIntegers(input.hasNextInt());

            // Beginning of while 5 > hoursWorked > 40 ************************************
            while (hoursWorked > 40 || hoursWorked < 5) {
                // Beginning of if hoursWorked > 40 ****************************************
                if (hoursWorked > 40) {
                    // Print: "Hours worked cannot EXCEED 40. Please re-enter:"
                    System.out.println("Hours worked cannot EXCEED 40. Please re-enter: ");
                    hoursWorked = input.nextInt();
                } // Ending of if hoursWorked > 40 ******************************************

                // Beginning of if hoursWorked < 5 ******************************************
                if (hoursWorked < 5) {
                    // Print: "Hours worked cannot be LESS than 5. Please re-enter:"
                    System.out.printf("%nHours worked cannot be LESS than 5. Please re-enter: ");
                    hoursWorked = input.nextInt();
                } // Ending if hoursWorked < 5 **********************************************

                // Call validateIntegers() in assignment to hoursWorked
                hoursWorked = validateIntegers(input.hasNextInt());

            } // Ending of while 5 > hoursWorked > 40 **************************************

            // 4th Prompt: "Enter the employee's hourly pay rate:"
            System.out.printf("%nEnter the employee's hourly pay rate: ");

            // Call validateDecimals() to check double
            payRate = validateDecimals(input.hasNextDouble());

            // Beginning while payRate < 7.25 OR > 26.00 **********************************
            while ((payRate < 7.25) || (payRate > 26.00)) {
                // Beginning if payRate less than 7.25 ************************************
                if (payRate < 7.25) {
                    // Print: "Hourly pay cannot be LESS than $7.25. Please re-enter:"
                    System.out.println("Hourly pay cannot be LESS than $7.25. Please re-enter: ");
                } // Ending if payRate < 7.25 **********************************************

                // Beginning if payRate greater than 26.00 *********************************
                if (payRate > 26.00) {
                    // Print: "Hourly pay cannot EXCEED $26.00. Please re-enter:"
                    System.out.println("Hourly pay cannot EXCEED $26.00. Please re-enter: ");
                } // Ending if payRate greater than 26.00 **********************************

                // Call validateDecimals() in assignment to payRate
                payRate = validateDecimals(input.hasNextDouble());

            } // Ending while payRate < 7.25 OR > 26.00 ************************************

            // Calculate grossPay: Multiply hoursWorked by payRate
            grossPay = hoursWorked * payRate;

            // Add grossPay to grossPayAllEmpl
            grossPayAllEmpl += grossPay;

            // 5th Prompt: "Enter the employee's 401k contribution as a percentage of salary (not to exceed 10%):"
            System.out.printf("%nEnter the employee's 401k contribution as a" +
                    "percentage of salary (not to exceed 10%%):");

            // Calculate percent401k into decimals
            percent401k = validateDecimals(input.hasNextDouble());

            // Beginning while percent401k is greater than 10.00 ***************************
            while (percent401k > 10.00) {
                // Print: "Contribution cannot EXCEED 10%. Please re-enter:"
                System.out.printf("Contribution cannot EXCEED 10%%. Please re-enter:");
                // Call validateDecimals() in assignment to percent401k
                percent401k = validateDecimals(input.hasNextDouble());
            } // Ending while percent401k is greater than 10.00 ****************************

            // Calculate empl401k: Divide percent401k by 100 and multiply by grossPay
            empl401k = percent401k / 100 * grossPay;

            // Add empl401k to total401kAllEmpl
            total401kAllEmpl += empl401k;

            // Code the if-else for trigger on page 6 of PA instructions *******************
            if (trigger == 1) {
                payrollExpense += String.format("%n%-30s %8s $%,15.2f %8s $%,13.2f", first + " " + last, " ", grossPay,
                        " ", empl401k);
                trigger = 0;
            } // Ending if trigger is 1 ****************************************************

            // Beginning if trigger is not 1 ***********************************************
            else {
                payrollExpense += String.format("%n%-30s %9s %,15.2f %9s %,13.2f", first +
                        " " + last, " ", grossPay, " ", empl401k);
            } // Ending else trigger is not 1 **********************************************

            // Clear buffer
            input.nextLine();

            // 6th Prompt: "Enter 'Y' to add another employee or 'N' to exit:"
            System.out.println("Enter 'Y' to add another employee or 'N' to exit: ");
            cont = input.next().charAt(0);
            input.nextLine(); // Clear buffer

            // Beginning of if cont is 'n' ************************************************
            if (cont == 'n' || cont == 'N') {
                // Code the Java statements at the end of page 6, beginning of 7 in PA instructions
                payrollExpense += String.format("%n%n%25s TOTALS %6s " +
                        "$%,15.2f %8s $%,13.2f", " ", " ",
                        grossPayAllEmpl, " ", total401kAllEmpl);
                // PRINTS THE FINAL OUTPUT STORED IN payrollExpense
                System.out.printf("%n%n%s", payrollExpense);
            } // Ending of if cont is 'n' **************************************************

        } // Ending of while cont is y *****************************************************

        // Stop program
        //System.exit(0);

    } // Ending of main **********************************************************************

    /**
     * Code validateIntegers() on pages 7 of PA instructions
     * validateIntegers() accepts a boolean reflecting
     * whether a number is an integer (true) or not (false)
     * for an employee's hours worked. Uses a while loop
     * to re-prompt until the value is an integer which is
     * returned to the calling statement.
     */
    public static int validateIntegers(boolean isInt) {
        int anInt = 0; // Stores a validated integer value.
        // Beginning of while NOT an integer **********************************************
        while (!isInt) {
            input.next();
            System.out.printf("%nInvalid integer! Re-enter "
                    + "the hours worked: ");
            isInt = input.hasNextInt();
        } // Ending of while NOT an integer ***********************************************
        anInt = input.nextInt();
        return anInt;
    } // Ending validateIntegers() ***********************************************************

    /**
     * validateDecimals() on pages 7-8 of PA instructions
     * validateDecimals() accepts a boolean reflecting
     * whether a number is a decimal (true) or not (false)
     * for an employee's pay rate or 401k contribution
     * percentage. Uses a while loop to re-prompt until
     * the value is a double which is returned to the calling
     * statement.
     */
    public static double validateDecimals(boolean isDouble) {
        double aDouble = 0.0; // Stores a validated decimal value.

        // Beginning of while NOT a double ************************************************
        while (!isDouble) {
            input.next();
            System.out.printf("%nInvalid decimal! Re-enter "
                    + "the pay rate or the 401k percentage "
                    + "contribution: ");
            isDouble = input.hasNextDouble();
        } // Ending of while NOT a double ***************************************************
        aDouble = input.nextDouble();
        return aDouble;
    } // Ending validateDecimals() ************************************************************
} // Ending of Class AlcoserC004PA2******************************************************************** 



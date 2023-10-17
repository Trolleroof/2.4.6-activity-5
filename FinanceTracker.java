import java.util.ArrayList;
import java.util.Scanner;

public class FinanceTracker {
    private static double totalIncome = 0; // Declare as class-level variable
    private static double totalExpenses = 0; // Declare as class-level variable
    private static ArrayList<String> transactions = new ArrayList<>(); // Class-level variable

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Personal Finance Tracker");
            System.out.println("1. Add Transaction");
            System.out.println("2. Calculate Savings");
            System.out.println("3. Display Transaction History");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                addTransaction();
            } else if (choice == 2) {
                calculateSavings();
            } else if (choice == 3) {
                displayTransactions();
            } else if (choice == 4) {
                System.out.println("Exiting the Fintracker");
                break;
            } else {
                System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    public static void addTransaction() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if (categorizeTransaction(description)) {
            totalIncome += amount; 
        } else {
            totalExpenses += amount; 
        }

        transactions.add(description);
        System.out.println("Transaction added successfully.");
        System.out.println();

    }

    public static boolean categorizeTransaction(String description) {
        String desc = description.toLowerCase();
        return desc.contains("salary") || desc.contains("income");
    }

    public static void calculateSavings() {
        double savings = totalIncome - totalExpenses;
        System.out.println("Total Income: " + totalIncome);
        System.out.println("Total Expenses: " + totalExpenses);
        System.out.println("Savings: " + savings);
        System.out.println();
    }

    public static void displayTransactions() {
        System.out.println("Transaction History: ");
        for (String transaction : transactions) {
            System.out.println(transaction);
            
        }
        System.out.println();
    }
}

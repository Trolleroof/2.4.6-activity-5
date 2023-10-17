import java.util.ArrayList;
import java.util.Scanner;

public class FinanceTracker {
    public static void main(String[] args) {
        ArrayList<String> transactions = new ArrayList<>();
        double totalIncome = 0;
        double totalExpenses = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Personal Finance Tracker");
            System.out.println("1. Add Transaction");
            System.out.println("2. Calculate Savings");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  
            if (choice == 1) {
                addTransaction(transactions, totalIncome, totalExpenses);
            } else if (choice == 2) {
                calculateSavings(totalIncome, totalExpenses);
            } else if (choice == 3) {
                System.out.println("Exiting the Fintracker");
                break;
            } else {
                System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    public static void addTransaction(ArrayList<String> transactions, double totalIncome, double totalExpenses) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        TransactionType type = categorizeTransaction(description);

        transactions.add(description);

        if (type == TransactionType.INCOME) {
            totalIncome += amount;
        } else {
            totalExpenses += amount;
        }
        System.out.println("Transaction added successfully.");
    }

    public static TransactionType categorizeTransaction(String description) {
        String desc = description.toLowerCase();
        if (desc.contains("salary") || desc.contains("income")) {
            return TransactionType.INCOME;
        } else {
            return TransactionType.EXPENSE;
        }
    }

    public static void calculateSavings(double totalIncome, double totalExpenses) {
        double savings = totalIncome - totalExpenses;
        System.out.println("Total Income: " + totalIncome);
        System.out.println("Total Expenses: " + totalExpenses);
        System.out.println("Savings: " + savings);
    }
}

enum TransactionType {
    INCOME, EXPENSE
}

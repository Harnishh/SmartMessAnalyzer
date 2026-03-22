import java.util.ArrayList;
import java.util.Scanner;

public class main {
    static ArrayList<Feedback> feedbacks = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);
    static int id = 1;

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n----- Mess Feedback System -----");
            System.out.println("1. Add Feedback");
            System.out.println("2. View All Feedback");
            System.out.println("3. Average Rating");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            if (choice == 1) {
                addFeedback();
            } 
            else if (choice == 2) {
                showFeedback();
            } 
            else if (choice == 3) {
                calculateAverage();
            } 
            else if (choice == 4) {
                System.out.println("Program ended.");
            } 
            else {
                System.out.println("Wrong choice, try again.");
            }

        } while (choice != 4);
    }

    
    public static void addFeedback() {

        System.out.print("Enter food name: ");
        String food = sc.nextLine();

        System.out.print("Enter rating (1 to 5): ");
        int rating = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter your comment: ");
        String comment = sc.nextLine();

        Feedback f = new Feedback(id, food, rating, comment);
        feedbacks.add(f);

        id++; 

        System.out.println("Feedback saved successfully!");
    }

    
    public static void showFeedback() {

        if (feedbacks.size() == 0) {
            System.out.println("No feedback given yet.");
            return;
        }

        for (Feedback f : feedbacks) {
            System.out.println("\nID: " + f.id);
            System.out.println("Food Item: " + f.foodItem);
            System.out.println("Rating: " + f.rating);
            System.out.println("Comment: " + f.comment);
        }
    }

    
    public static void calculateAverage() {

        if (feedbacks.size() == 0) {
            System.out.println("No data to calculate average.");
            return;
        }

        int total = 0;

        for (Feedback f : feedbacks) {
            total = total + f.rating;
        }

        double avg = (double) total / feedbacks.size();

        System.out.println("Average Rating is: " + avg);
    }
}

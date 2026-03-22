import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {

    static ArrayList<Feedback> feedbacks = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int id = 1;

    public static void main(String[] args) {

        loadFromFile();

        int choice;

        do {
            System.out.println("\n----- Mess Feedback System -----");
            System.out.println("1. Add Feedback");
            System.out.println("2. View All Feedback");
            System.out.println("3. Average Rating");
            System.out.println("4. Analyze Comments");
            System.out.println("5. Exit");

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
                Analyzer.analyzeComments(feedbacks);
            } 
            else if (choice == 5) {
                saveToFile();
                System.out.println("Data saved. Program ended.");
            } 
            else {
                System.out.println("Invalid choice.");
            }

        } while (choice != 5);
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

        System.out.println("Feedback added successfully!");
    }

    public static void showFeedback() {

        if (feedbacks.size() == 0) {
            System.out.println("No feedback available.");
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
            System.out.println("No data available.");
            return;
        }

        int total = 0;

        for (Feedback f : feedbacks) {
            total += f.rating;
        }

        double avg = (double) total / feedbacks.size();
        System.out.println("Average Rating: " + avg);
    }

    public static void saveToFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("data.txt"));

            for (Feedback f : feedbacks) {
                bw.write(f.id + "|" + f.foodItem + "|" + f.rating + "|" + f.comment);
                bw.newLine();
            }

            bw.close();

        } catch (Exception e) {
            System.out.println("Error saving file.");
        }
    }

    public static void loadFromFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("data.txt"));
            String line;

            while ((line = br.readLine()) != null) {

                String[] parts = line.split("\\|");

                if (parts.length == 4) {

                    int fid = Integer.parseInt(parts[0]);
                    String food = parts[1];
                    int rating = Integer.parseInt(parts[2]);
                    String comment = parts[3];

                    feedbacks.add(new Feedback(fid, food, rating, comment));

                    if (fid >= id) {
                        id = fid + 1;
                    }
                }
            }

            br.close();

        } catch (FileNotFoundException e) {
            System.out.println("No previous data found.");
        } catch (Exception e) {
            System.out.println("Error reading file.");
        }
    }
}
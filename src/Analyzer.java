import java.util.ArrayList;

public class Analyzer {
    public static void analyzeComments(ArrayList<Feedback> feedbacks) {

        if (feedbacks.size() == 0) {
            System.out.println("No feedback to analyze.");
            return;
        }

        int badCount = 0;
        int oilyCount = 0;
        int coldCount = 0;
        int tastyCount = 0;
        int goodCount = 0;

        for (Feedback f : feedbacks) {

            String comment = f.comment.toLowerCase();

            if (comment.contains("bad")) {
                badCount++;
            }

            if (comment.contains("oily")) {
                oilyCount++;
            }

            if (comment.contains("cold")) {
                coldCount++;
            }

            if (comment.contains("tasty")) {
                tastyCount++;
            }

            if (comment.contains("good")) {
                goodCount++;
            }
        }

        System.out.println("\n--- Feedback Analysis ---");
        System.out.println("Bad comments: " + badCount);
        System.out.println("Oily mentions: " + oilyCount);
        System.out.println("Cold mentions: " + coldCount);
        System.out.println("Tasty mentions: " + tastyCount);
        System.out.println("Good mentions: " + goodCount);
    }
}

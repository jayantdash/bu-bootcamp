import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GradeAnalyzer {
    static int invalidLines = 0;
    public static void main(String[] args) {
        
        if (args.length < 1) {
            System.err.println("Please provide the input file name as a command line argument.");
            System.exit(1);
        }

        final String inputFileName = args[0];
        final String outputFileName = "report.txt";

        // if both highest and lowest scores are 0, then the file is empty or contains invalid data. In that case, print a message and exit the program.

        int highestScore = 0;
        int lowestScore = 0;


        ArrayList<Integer> scores = readScores(inputFileName);
        double average = calculateAverage(scores);


        if (!scores.isEmpty()) {
            highestScore = Integer.MIN_VALUE;
            lowestScore = Integer.MAX_VALUE;

            for (int score : scores) {
                if (score > highestScore) {
                    highestScore = score;
                }
                if (score < lowestScore) {
                    lowestScore = score;
                }
            }
        }

        writeReport(scores, average, highestScore, lowestScore, outputFileName);        
    }

    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> scores = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim(); // Remove leading and trailing whitespace
                if (line.isEmpty()) {
                    invalidLines++;
                    System.err.println("Ignoring empty line");
                    continue; // Skip empty lines
                }

                try {
                    int score = Integer.parseInt(line);
                    // number should be in between 0 and 100. If any of the lines in the file is not a number, ignore it and continue to the next line.                    
                    if (score >= 0 && score <= 100) {
                        scores.add(score);
                    } else {
                        invalidLines++;
                        System.err.println("Ignoring invalid score: " + score);
                    }
                } catch (NumberFormatException e) {
                    invalidLines++;
                    System.err.println("Invalid score format: " + e.getMessage());
                }
            }

            if (invalidLines == 0 && scores.isEmpty()) {
                System.err.println("The file is empty.");
            } else if (invalidLines > 0 && scores.isEmpty()) {
                System.err.println("The file contains only invalid scores.");
            } else {
                System.out.println("Total valid scores read: " + scores.size());
                System.out.println("Total invalid lines skipped: " + invalidLines);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        return scores;
    }
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.size();
    }
 
    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   String outputFile) {

        if (!scores.isEmpty()) {
            int countA = 0;
            int countB = 0;
            int countC = 0;
            int countD = 0;
            int countF = 0;

            for (int score : scores) {
                if (score >= 90) {
                    countA++;
                } else if (score >= 80) {
                    countB++;
                } else if (score >= 70) {
                    countC++;
                } else if (score >= 60) {
                    countD++;
                } else {
                    countF++;
                }
            }
            

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
                bw.write("=== Grade Analysis Report ===\n");
                bw.write(String.format("Total scores processed:\t%d\n", scores.size()));
                bw.write(String.format("Invalid lines skipped:\t%d\n", invalidLines));

                bw.write("\n");

                bw.write(String.format("Average score:\t%.2f\n", avg));
                bw.write(String.format("Highest score:\t%d\n", high));
                bw.write(String.format("Lowest score:\t%d\n", low));

                bw.write("\n");

                bw.write("Grade Distribution:\n");

                bw.write(String.format("  A (90-100):\t%d\n", countA));
                bw.write(String.format("  B (80-89):\t%d\n", countB));
                bw.write(String.format("  C (70-79):\t%d\n", countC));
                bw.write(String.format("  D (60-69):\t%d\n", countD));
                bw.write(String.format("  F (below 60):\t%d\n", countF));

            } catch (IOException e) {
                System.err.println("Error writing the file: " + e.getMessage());
            }


            // Print the report to the console
            System.out.println();
            System.out.println();
            System.out.println("=== Grade Analysis Report ===");
            System.out.println(String.format("Total scores processed:\t%d", scores.size()));
            System.out.println(String.format("Invalid lines skipped:\t%d", invalidLines));

            System.out.println();

            System.out.println(String.format("Average score:\t%.2f", avg));
            System.out.println(String.format("Highest score:\t%d", high));
            System.out.println(String.format("Lowest score:\t%d", low));

            System.out.println();

            System.out.println("Grade Distribution:");

            System.out.println(String.format("  A (90-100):\t%d", countA));
            System.out.println(String.format("  B (80-89):\t%d", countB));
            System.out.println(String.format("  C (70-79):\t%d", countC));
            System.out.println(String.format("  D (60-69):\t%d", countD));
            System.out.println(String.format("  F (below 60):\t%d", countF));
        } else {
            System.err.println("No valid scores to report.");
        }
    }
}

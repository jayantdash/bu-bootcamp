import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NumberRead {
    public static void main(String[] args) {
        String fileName = "numbers.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                int number = Integer.parseInt(line);
                System.out.println("Original number: " + number + ", Doubled: " + (number * 2));
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format: " + e.getMessage());
        } finally {
            System.out.println("Finished processing the file.");
        }
    }
}
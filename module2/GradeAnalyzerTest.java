import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class GradeAnalyzerTest {
 
    @Test
    void calculateAverage_returnsZero_whenListIsEmpty() { 
        ArrayList<Integer> scores = new ArrayList<>(); 
        assertEquals(0.0, GradeAnalyzer.calculateAverage(scores)); 
    } 
 
    @Test
    void calculateAverage_returnsCorrectAverage_forTypicalScores() { 
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(80, 90, 100)); 
        assertEquals(90.0, GradeAnalyzer.calculateAverage(scores));
    }
 
    @Test
    void calculateAverage_returnsSingleValue_whenListHasOneItem() { 
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(75)); 
        assertEquals(75.0, GradeAnalyzer.calculateAverage(scores));
    } 
 
    @Test
    void calculateAverage_returnsDouble_notInteger() { 
        // 1 + 2 = 3, divided by 2 = 1.5, not 1
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(1, 2)); 
        assertEquals(1.5, GradeAnalyzer.calculateAverage(scores)); 
    } 
 
    @Test 
    void calculateAverage_handlesAllSameValues() { 
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(88, 88, 88)); 
        assertEquals(88.0, GradeAnalyzer.calculateAverage(scores)); 
    }

    @Test
    void calculateAverage_returnsCorrectAverage_forLargerScores() {
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(76, 20, 30, 84, 100, 90, 80, 70, 60, 50)); 
        assertEquals(66.0, GradeAnalyzer.calculateAverage(scores));
    }

    @Test 
    void getLetterGrade_returnsB_forScoreOf89() {
        assertEquals("B", GradeAnalyzer.getLetterGrade(89)); 
    } 
 
    @Test 
    void getLetterGrade_returnsA_forScoreOf90() { 
        assertEquals("A", GradeAnalyzer.getLetterGrade(90)); 
    } 
        
    @Test 
    void getLetterGrade_returnsC_forScoreOf79() {
        assertEquals("C", GradeAnalyzer.getLetterGrade(79)); 
    } 
        
    @Test 
    void getLetterGrade_returnsB_forScoreOf80() {
        assertEquals("B", GradeAnalyzer.getLetterGrade(80)); 
    }

       @Test 
    void getLetterGrade_returnsD_forScoreOf69() {
        assertEquals("D", GradeAnalyzer.getLetterGrade(69)); 
    } 
 
    @Test 
    void getLetterGrade_returnsC_forScoreOf70() { 
        assertEquals("C", GradeAnalyzer.getLetterGrade(70)); 
    } 
        
    @Test 
    void getLetterGrade_returnsF_forScoreOf59() {
        assertEquals("F", GradeAnalyzer.getLetterGrade(59)); 
    } 
        
    @Test 
    void getLetterGrade_returnsD_forScoreOf60() {
        assertEquals("D", GradeAnalyzer.getLetterGrade(60)); 
    } 
}
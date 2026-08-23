import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach; 
 
public class ContactTest { 
 
    private Contact contact1;
    private Contact contact2;

    @BeforeEach
    void setUp() {
        contact1 = new Contact("Ada Lovelace", "+1 617 555 0101");
        contact2 = new Contact("Alan Turing", "555-0001"); 
    }   

    @Test 
    void constructor_setsNameCorrectly() { 
        assertEquals("Ada Lovelace", contact1.getName()); 
    } 
 
    @Test
    void constructor_setsPhoneCorrectly() { 
        assertEquals("+1 617 555 0101", contact1.getPhoneNumber()); 
    } 
    
    @Test
    void getName_returnsExactString_notTransformed() { 
        Contact c = new Contact("Grace Hopper", "555-0000"); 
        assertEquals("Grace Hopper", c.getName());
    } 
    
    @Test
    void toString_containsName() { 
        assertTrue(contact2.toString().contains("Alan Turing"));
    } 
    
    @Test
    void toString_containsPhone() {
        assertTrue(contact2.toString().contains("555-0001"));
    }

    @Test
    void toString_formatsCorrectly() {
        assertEquals("Ada Lovelace | +1 617 555 0101", contact1.toString());
    }

    @Test
    void twoContactObjectsWithSameNameAreIndependent() {
     Contact c1 = new Contact("John Doe", "123-4567");
     Contact c2 = new Contact("John Doe", "123-4568");

     assertEquals("John Doe", c1.getName());
     assertEquals("John Doe", c2.getName());

    // Verify both Contact object maintain independent phone numbers
     assertEquals("123-4567", c1.getPhoneNumber());
     assertEquals("123-4568", c2.getPhoneNumber());
    }
} 
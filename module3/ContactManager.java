import java.util.*; 
 
public class ContactManager { 
 
    public static void main(String[] args) { 
 
        HashMap<String, Contact> contacts = new HashMap<>(); 
 
        // Step 4: add contacts here 
        addContact(contacts, "Ada Lovelace", "+1 617 555 0101");        
        addContact(contacts, "Grace", "+1 789 012 3456");
        addContact(contacts, "Alice", "+1 123 456 7890");
        addContact(contacts, "Bob", "+1 234 567 8901");
        addContact(contacts, "Charlie", "+1 345 678 9012");
        addContact(contacts, "David", "+1 456 789 0123");
        addContact(contacts, "Eve", "+1 567 890 1234");
        addContact(contacts, "Eve", "+1 567 890 1234");
        
        // Step 5: look up a contact
        fetchContact(contacts, "Ada Lovelace");
 
        // test with a name that does not exist to confirm the not-found message works.  
        fetchContact(contacts, "John Doe");

        // Step 6: print sorted list 
        sortAndPrintContacts(contacts);

        //remove contact
        removeContact(contacts, "John Doe");
        sortAndPrintContacts(contacts);

        removeContact(contacts, "Ada Lovelace");
        sortAndPrintContacts(contacts);

    } 

    private static void fetchContact(HashMap<String, Contact> contacts, String name) {
        System.out.println(String.format("\nLooking up %s...", name));
        Contact contact = contacts.get(name);
        if (contact != null) {
            System.out.println("\tContact found.");
            System.out.println("\t" + contact);
        } else {
            System.out.println("\tContact not found.");
        }
    }

    private static void addContact(HashMap<String, Contact> contacts, String name, String phoneNumber) {
        System.out.println(String.format("Trying to add %s into the list...", name));
        if (contacts.get(name) == null) {
            contacts.put(name, new Contact(name, phoneNumber));
            System.out.println(String.format("\t%s is added in the list", name));
        } else {
            System.out.println(String.format("\t%s is already in the list", name));
        }
    }

    private static void removeContact(HashMap<String, Contact> contacts, String name) {

        System.out.println(String.format("\nTrying to remove %s from the list...", name));
        if (contacts.remove(name) != null) {
            System.out.println(String.format("\t%s was removed from the list", name));
        } else {
            System.out.println(String.format("\t%s was not found in the list", name));
        }
    }

    private static void sortAndPrintContacts(HashMap<String, Contact> contacts) {
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));  
        
        System.out.println("\n=== All Contacts ===");
        
        for (Contact contact : sorted) {
            System.out.println(contact);
        }
    }
}
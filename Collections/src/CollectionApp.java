import java.util.*;

public class CollectionApp {

    public static void main(String[] args) {
        System.out.println("\nStarting ArrayList test...");
        testArrayList();

        System.out.println("\nStarting LinkedList test...");
        testLinkedList();

        System.out.println("\nStarting Hashtable test...");
        testHashtable();
    }

    public static void testArrayList() {
        List<Integer> arrayList = new ArrayList<>();
        Random rand = new Random();

        System.out.println("Adding 2,000,000 integers to array list...");
        for (int i = 0; i < 2_000_000; i++) {
            arrayList.add(rand.nextInt());
        }

        System.out.println("Removing 2,000,000 integers from array list...");
        arrayList.clear();
        System.out.println("ArrayList test complete.");
    }

    public static void testLinkedList() {
        List<Integer> linkedList = new LinkedList<>();
        Random rand = new Random();

        System.out.println("Adding 2,000,000 integers to linked list...");
        for (int i = 0; i < 2_000_000; i++) {
            linkedList.add(rand.nextInt());
        }

        System.out.println("Removing 2,000,000 integers from linked list...");
        linkedList.clear();
        System.out.println("LinkedList test complete.");
    }

    public static void testHashtable() {
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        Random rand = new Random();

        System.out.println("Adding 2,000,000 integers to hash table...");
        for (int i = 0; i < 2_000_000; i++) {
            int key = rand.nextInt();
            hashtable.put(key, rand.nextInt());
        }

        System.out.println("Removing 2,000,000 integers from hash table...");
        hashtable.clear();
        System.out.println("Hashtable test complete.");
    }
}

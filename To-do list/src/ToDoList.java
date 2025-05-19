/*
 * The ToDoList class houses the main three methods that will be used in the app,
 * to add, remove, and view items in our to-do list.
 */

import java.util.*;

public class ToDoList {
    public List<String> items;

    public ToDoList() {
        items = new ArrayList<>();
    }

    public void add(String item) {
        items.add(item);
        System.out.println(item + " added to the list");
    }

    public void remove(int index) {
        if (index >=0 && index < items.size()) {
            System.out.println(items.get(index) + " removed from the list");
            items.remove(index);
        } else {
            System.out.println("Invalid index. No item deleted.");
        }
    }

    public List<String> getItems() {
        return new ArrayList<>(items);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}

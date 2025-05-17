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
            items.remove(index);
            System.out.println(items.get(index) + " removed from the list");
        } else {
            System.out.println(items.get(index) + " is not in the list");
        }
    }

    public List<String> getItems() {
        return new ArrayList<>(items);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}

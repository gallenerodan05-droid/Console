import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class atay {

    


    public static void main(String[] args) {
        Map<String, Integer> inventory = new HashMap<>();
        Queue<String> orders = new LinkedList<>();
        Deque<String> processed = new ArrayDeque<>();
        Set<String> outOfStock = new HashSet<>();

inventory.put("Apple", 3);
inventory.put("Banana", 2);
inventory.put("Mango", 0);

orders.add("Alice-Apple");
orders.add("Bob-Mango");
orders.add("Charlie-Banana");
orders.add("Dan-Apple");
orders.add("Eve-Banana");
orders.add("Frank-Apple");

while(!orders.isEmpty()) {
    String order = orders.poll();
    String[] parts = order.split("-");
    String customer = parts[0];
    String item = parts[1];

    if(outOfStock.contains(item)) {
        System.out.println(customer + " cannot order " + item + " - out of stock");
        continue;
    }

    int stock = inventory.get(item);
    if(stock == 0) {
        outOfStock.add(item);
    System.out.println(customer + " cannot order " + item + " - out of stock");
        continue;
    }

    inventory.put(item, stock - 1);
    processed.push(order);
    System.out.println(customer + " ordered " + item);
}

System.out.println("Remaining inventory: " + inventory);
System.out.println("Last processed: " + processed.peek());
System.out.println("Out of stock items: " + outOfStock);
    }
    
} 
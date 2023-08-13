//Write & Execute C++/Java Program to solve Knapsack problem using Greedy
method.
import java.util.Arrays;
public class KnapsackGreedy {
// Class representing an item with weight and value
static class Item implements Comparable<Item> {
int weight;
int value;
public Item(int weight, int value) {
this.weight = weight;
this.value = value;
}
// Compare items based on their value-to-weight ratio
public int compareTo(Item other) {
double ratio1 = (double) value / weight;
double ratio2 = (double) other.value / other.weight;
if (ratio1 > ratio2) {
return -1;
} else if (ratio1 < ratio2) {
return 1;
} else {
return 0;
}
}
}
// Method to solve the knapsack problem using a greedy approach
public static int knapsackGreedy(int[] weights, int[] values, int capacity) {
int n = weights.length;
Item[] items = new Item[n];
// Create an array of items with their respective weights and values
for (int i = 0; i < n; i++) {
items[i] = new Item(weights[i], values[i]);
}
// Sort the items in descending order based on their value-to-weight ratio
Arrays.sort(items);
int totalValue = 0;
int currentWeight = 0;
int i = 0;
// Add items to the knapsack until the capacity is reached or all items are
considered
while (currentWeight < capacity && i < n) {
if (currentWeight + items[i].weight <= capacity) {
// If the current item can be fully added, add its value and update the current
weight
weight
currentWeight += items[i].weight;
totalValue += items[i].value;
} else {
// If the current item cannot be fully added, calculate the remaining weight
// that can be added proportionally and update the total value and current
int remainingWeight = capacity - currentWeight;
totalValue += (int) ((double) items[i].value / items[i].weight *
remainingWeight);
currentWeight = capacity;
}
i++;
}
return totalValue;
}
public static void main(String[] args) {
int[] weights = {10, 20, 30};
int[] values = {60, 100, 120};
int capacity = 50;
int maxTotalValue = knapsackGreedy(weights, values, capacity);
System.out.println("Maximum total value: " + maxTotalValue);
}
}

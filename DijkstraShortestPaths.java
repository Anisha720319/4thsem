Write & Execute C++/Java Program to find shortest paths to other vertices from
a given vertex in a weighted connected graph, using Dijkstra's algorithm.
import java.util.Arrays;
import java.util.PriorityQueue;
public class DijkstraShortestPaths {
static class Edge {
int target;
int weight;
public Edge(int target, int weight) {
this.target = target;
this.weight = weight;
}
}
// Method to find the shortest paths from a given source vertex to all other vertices
in a graph
public static void shortestPaths(int[][] graph, int source) {
int n = graph.length;
int[] distances = new int[n];
Arrays.fill(distances, Integer.MAX_VALUE);
distances[source] = 0;
// Use a priority queue to store edges based on their weights
PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
pq.offer(new Edge(source, 0));
while (!pq.isEmpty()) {
Edge edge = pq.poll();
int u = edge.target;
// Explore all neighboring vertices of the current vertex
for (int v = 0; v < n; v++) {
if (graph[u][v] != 0) {
int newDistance = distances[u] + graph[u][v];
if (newDistance < distances[v]) {
// If a shorter path is found, update the distance and add the edge to
the priority queue
distances[v] = newDistance;
pq.offer(new Edge(v, newDistance));
}
}
}
}
// Print the shortest paths from the source vertex to all other vertices
System.out.println("Shortest paths from vertex " + source + ":");
for (int i = 0; i < n; i++) {
System.out.println("Vertex " + i + ": " + distances[i]);
}
}
public static void main(String[] args) {
int[][] graph = {
{0, 4, 2, 0, 0},
{4, 0, 1, 5, 0},
{2, 1, 0, 8, 10},
{0, 5, 8, 0, 2},
{0, 0, 10, 2, 0}
};
int source = 0;
shortestPaths(graph, source);
}
}


//Write & Execute C++/Java Program to find Minimum Cost Spanning Tree of a given
connected undirected graph using Kruskal's algorithm. Use Union-Find algorithms in your
program.
import java.util.Arrays;
public class KruskalMinimumSpanningTree {
static class Edge implements Comparable<Edge> {
int source;
int target;
int weight;
public Edge(int source, int target, int weight) {
this.source = source;
this.target = target;
this.weight = weight;
}
public int compareTo(Edge other) {
return this.weight - other.weight;
}
}
static class UnionFind {
int[] parent;
int[] rank;
public UnionFind(int n) {
parent = new int[n];
rank = new int[n];
for (int i = 0; i < n; i++) {
parent[i] = i;
rank[i] = 0;
}
}
public int find(int x) {
if (parent[x] != x) {
parent[x] = find(parent[x]);
}
return parent[x];
}
public void union(int x, int y) {
int rootX = find(x);
int rootY = find(y);
if (rank[rootX] < rank[rootY]) {
parent[rootX] = rootY;
} else if (rank[rootX] > rank[rootY]) {
parent[rootY] = rootX;
} else {
parent[rootY] = rootX;
rank[rootX]++;
}
}
}
// Method to find the minimum spanning tree using Kruskal's algorithm
public static void minimumSpanningTree(int[][] graph) {
int n = graph.length;
// Create an array to store all edges in the graph
Edge[] edges = new Edge[n * n];
int count = 0;
for (int i = 0; i < n; i++) {
for (int j = i + 1; j < n; j++) {
if (graph[i][j] != 0) {
edges[count] = new Edge(i, j, graph[i][j]);
count++;
}
}
}
// Sort the edges array based on their weights
Arrays.sort(edges, 0, count);
// Create an array to store the edges in the minimum spanning tree
Edge[] mst = new Edge[n - 1];
int mstCount = 0;
// Create a UnionFind data structure to track connected components
UnionFind uf = new UnionFind(n);
// Iterate over the sorted edges
for (int i = 0; i < count; i++) {
Edge edge = edges[i];
int source = edge.source;
int target = edge.target;
// Check if adding this edge creates a cycle
if (uf.find(source) != uf.find(target)) {
uf.union(source, target);
mst[mstCount] = edge;
mstCount++;
}
}
// Print the minimum cost spanning tree
System.out.println("Minimum Cost Spanning Tree:")
for (int i = 0; i < mstCount; i++) {
Edge edge = mst[i];
System.out.println(edge.source + " - " + edge.target + " : " + edge.weight);
}
}
public static void main(String[] args) {
int[][] graph = {
{0, 2, 0, 6, 0},
{2, 0, 3, 8, 5},
{0, 3, 0, 0, 7},
{6, 8, 0, 0, 9},
{0, 5, 7, 9, 0}
};
minimumSpanningTree(graph);
}
}

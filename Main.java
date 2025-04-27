class Main {
  public static void main(String[] args) {
    // Add vertices (buildings)
    String[] vertices = {
      "Liberal Arts",
      "Student Services",
      "Health Careers & Sciences",
      "Health Technologies Center",
      "Recreation Center",
      "Technology Learning Center",
      "Business & Technology",
      "Theatre"
    };

    // Add edges (connections based on the map)
    int[][] edges = {
      {0, 1}, // Liberal Arts <-> Student Services
      {1, 2}, // Student Services <-> Health Careers & Sciences
      {2, 3}, // Health Careers & Sciences <-> Health Technologies Center
      {1, 4}, // Student Services <-> Recreation Center
      {4, 5}, // Recreation Center <-> Technology Learning Center
      {5, 6}, // Technology Learning Center <-> Business & Technology
      {6, 7}, // Business & Technology <-> Theatre
      {7, 0}, // Theatre <-> Liberal Arts
      {5, 1}  // Technology Learning Center <-> Student Services (optional shortcut)
    };

    // Create the graph
    Graph<String> graph = new UnweightedGraph<>(vertices, edges);

    // Create DFS starting from Business & Technology
    UnweightedGraph<String>.SearchTree dfs = graph.dfs(graph.getIndex("Business & Technology"));

    // Print DFS search order
    java.util.List<Integer> searchOrders = dfs.getSearchOrder();
    System.out.println(dfs.getNumberOfVerticesFound() + " vertices are searched in this DFS order:");
    for (int i = 0; i < searchOrders.size(); i++)
      System.out.print(graph.getVertex(searchOrders.get(i)) + " ");
    System.out.println();

    for (int i = 0; i < searchOrders.size(); i++)
      if (dfs.getParent(i) != -1)
        System.out.println("parent of " + graph.getVertex(i) +
          " is " + graph.getVertex(dfs.getParent(i)));

    // Print required paths
    System.out.println();
    dfs.printPath(graph.getIndex("Health Technologies Center"));
    System.out.println();
    dfs.printPath(graph.getIndex("Student Services"));
    System.out.println();
    dfs.printPath(graph.getIndex("Recreation Center"));
    System.out.println();

    // Print the whole tree
    System.out.println();
    dfs.printTree();
  }
}

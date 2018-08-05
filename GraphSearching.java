import java.util.Queue;

/**
 * This is for unidirectional trees despite the class name
 */
public class GraphSearching {
  public static void main(String[] args) {

  }

  private static void dfs(Node node) {
    if (node == null || node.visited) return;
    System.out.println(String.valueOf(node.data));
    node.visited = true;
    for (int i = 0; i < node.children.length; i++) {
      dfs(node.children[i]);
    }
  }

  private static void bfs(Node node) {
    if (node == null) return;
    Queue<Node> qnodes = new Queue<>();
    node.added = true;
    qnodes.enqueue(node);
    while (!qnodes.isEmpty()) {
      Node cur = qnodes.dequeue();
      System.out.println(String.valueOf(cur.data));
      for (Node n : cur.children) {
        if (!n.added) {
          n.added = true;
          qnodes.enqueue(n);
        }
      }
    }
  }

  public static class Graph {
    Node[] nodes;
  }

  public static class Node {
    int data;
    boolean visited = false;
    boolean added = false;
    Node[] children;
  }
}

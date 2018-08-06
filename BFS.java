import java.util.Queue;

public class BFS {

  public static void main(String[] args) {
  }

  public static boolean hasPath(Node n1, Node n2) {
    Queue<Node> queue = new Queue<>();
    queue.add(n1);
    while (!queue.isEmpty()) {
      Node cur = queue.remove();
      for (Node adjacentNode : cur.siblings) {
        if (!adjacentNode.visited) {
          if (cur == n2) return true;

          cur.visited = true;
          queue.add(adjacentNode);
        }
      }
    }
    return false;
  }

  public static class Graph {
    Node[] nodes;

    public boolean isEmpty() {
      return nodes.length == 0;
    }
  }

  public static class Node {
    int val;
    boolean visited = false;
    Node[] siblings;
  }
}

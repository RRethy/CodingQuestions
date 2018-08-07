public class BinaryTreeDepth {
  public static void main(String[] args) {

  }

  private static HashMap<Integer, LinkedList<BiNode>> toDepthLinkedListsDFS(HashMap<Integer, LinkedList<BiNode>> map,
      BiNode node,
      int depth) {
    if (node == null) return map;

    LinkedList<BiNode> nodes = map.get(depth);
    if (nodes == null) {
      nodes = new LinkedList<>();
      map.put(depth, nodes);
    }
    nodes.add(node);

    toDepthLinkedListsDFS(map, node.left, depth + 1);
    toDepthLinkedListsDFS(map, node.right, depth + 1);

    return map;
  }

  private static ArrayList<LinkedList<BiNode>> toDepthLinkedListBFS(BiNode root) {
    ArrayList<LinkedList<BiNode>> lists = new ArrayList<>();
    LinkedList<BiNode> cur = new LinkedList<>();
    if (root != null) cur.add(root);
    while (cur.size() > 0) {
      lists.add(cur);
      LinkedList<BiNode> next = new LinkedList<>();
      for (BiNode n : cur) {
        if (next.left != null) {
          next.add(next.left);
        }
        if (next.right != null) {
          next.add(next.right);
        }
      }
      cur = next;
    }
    return lists;
  }

  public static class BiNode {
    int val;
    BiNode left;
    BiNode right;

    public BiNode(int val) {
      this.val = val;
    }
  }
}

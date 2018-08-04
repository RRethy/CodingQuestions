import java.util.Arrays;

public class MinHeapImpl {

  public static void main(String[] args) {
    int[] heap = new int[1];
    int len = 0;

    heap = insert(3, heap, len++);
    heap = insert(8, heap, len++);
    heap = insert(5, heap, len++);
    heap = insert(4, heap, len++);
    heap = insert(2, heap, len++);
    heap = insert(1, heap, len++);
    for (int i : heap) {
      System.out.println(String.valueOf(i));
    }
    System.out.println("--------------------------");
    System.out.println(String.valueOf(extractmin(len--, heap)));
    System.out.println(String.valueOf(extractmin(len--, heap)));
    System.out.println(String.valueOf(extractmin(len--, heap)));
    System.out.println(String.valueOf(extractmin(len--, heap)));
    System.out.println(String.valueOf(extractmin(len--, heap)));
    System.out.println(String.valueOf(extractmin(len--, heap)));

    System.out.println(String.format("Len is %d", len));
  }

  /**
   * Children are at (i*2)+1 AND (i*2)+2
   */
  public static int[] insert(int val, int[] heap, int len) {
    if (heap.length == len) {
      int newlen = len * 2;
      heap = Arrays.copyOf(heap, newlen);
    }
    heap[len] = val;
    len++;

    int pos = len - 1;
    int parentIndex = getParentIndex(pos);
    while (pos != 0 && heap[pos] < heap[parentIndex]) {
      int tmp = heap[pos];
      heap[pos] = heap[parentIndex];
      heap[parentIndex] = tmp;
      pos = parentIndex;
      parentIndex = getParentIndex(pos);
    }

    return heap;
  }

  public static int getParentIndex(int i) {
    if (i % 2 == 0) {
      return (i - 2) / 2;
    } else {
      return (i - 1) / 2;
    }
  }

  public static int extractmin(int len, int[] heap) {
    if (len <= 0) return -1;
    int tmp = heap[0];
    heap[0] = heap[len - 1];
    heap[len - 1] = tmp;
    len--;

    int pos = 0;
    while (true) {
      int childCount = countChildren(len, pos, heap);
      if (childCount == 2) {
        int leftChild = heap[pos * 2 + 1];
        int rightChild = heap[pos * 2 + 2];
        if (leftChild > heap[pos] && rightChild > heap[pos]) break;
        int newpos = leftChild < rightChild ? pos * 2 + 1 : pos * 2 + 2;
        tmp = heap[pos];
        heap[pos] = heap[newpos];
        heap[newpos] = tmp;
        pos = newpos;
      } else if (childCount == 1) {
        if (heap[pos * 2 + 1] > heap[pos]) break;
        tmp = heap[pos];
        heap[pos * 2 + 1] = heap[pos];
        heap[pos] = tmp;
        pos = pos * 2 + 1;
      } else {
        break;
      }
    }

    return heap[len];
  }

  public static int countChildren(int len, int pos, int[] heap) {
    int count = 0;
    if (pos * 2 + 1 < len) count++;
    if (pos * 2 + 2 < len) count++;
    return count;
  }
}

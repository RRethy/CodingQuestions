public class MinHeapImpl {

  public static void main(String[] args) {
    int[] heap = new int[1];
    int len = 0;
  }

  public int[] insert(int val, int[] heap, int len) {
    if (heap.length == len) {
      int newlen = len * 2;
      heap = Arrays.copyOf(heap, newlen);
    }
    heap[len] = val;
    len++;


  }

  public void extractmin() {

  }
}

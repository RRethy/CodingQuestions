package CodingQuestions;

import java.util.Arrays;

public class MinHeapImpl2 {
  private int len = 0;
  private int[] heap = new int[1];

  public void insert(int val) {
    if (len == heap.length) {
      int newlen = len * 2;
      heap = Arrays.copyOf(heap, newlen);
    }

    int pos = len;
    heap[pos] = val;
    len++;

    while (getParent(pos) > heap[pos]) {
      int parentIndex = getParentIndex(pos);
      swap(parentIndex, pos);
      pos = parentIndex;
    }
  }

  public int removeMin() {
    if (isEmpty()) return -999;
    int min = heap[0];
    int replacement = heap[len - 1];

    len--;
    heap[0] = replacement;
    bubbleDown(0);

    return min;
  }

  public boolean isEmpty() {
    return len == 0;
  }

  private void bubbleDown(int i) {
    if (i >= len) return;

    int minIndex = i;
    int minVal = heap[i];

    if (i * 2 + 1 < len) {
      if (getLeftChild(i) < heap[i]) {
        minIndex = i * 2 + 1;
        minVal = getLeftChild(i);
      }
    }

    if (i * 2 + 2 < len) {
      if (getRightChild(i) < heap[i] && getRightChild(i) < minVal) {
        minIndex = i * 2 + 2;
      }
    }

    if (heap[minIndex] < heap[i]) {
      swap(minIndex, i);
      bubbleDown(minIndex);
    }
  }

  private int getLeftChild(int i) {
    return heap[i * 2 + 1];
  }

  private int getRightChild(int i) {
    return heap[i * 2 + 2];
  }

  private void swap(int i1, int i2) {
    int tmp = heap[i1];
    heap[i1] = heap[i2];
    heap[i2] = tmp;
  }

  private int getParentIndex(int i) {
    if (i % 2 == 1) return i / 2;
    return (i - 1) / 2;
  }

  private int getParent(int i) {
    return heap[getParentIndex(i)];
  }

  public void printBackingArray() {
    System.out.print("--------------\n");
    for (int i : heap) {
      System.out.print(String.valueOf(i));
    }
    System.out.print("\n--------------\n");
  }
}

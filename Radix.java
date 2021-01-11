import java.util.*;


public class Radix {
  public static int nth(int n, int col) {
    String val = ("" + Math.abs(n));
    int index = val.length() - 1 - col;
    return Integer.valueOf(val.substring(index, index + 1));
  }

  public static int length(int n) {
    return String.valueOf(Math.abs(n)).length();
  }

  public static void merge(SortableLinkedList original, SortableLinkedList[] buckets) {
    for (int i = 0; i < buckets.length; i++) {
      original.extend(buckets[i]);
    }
  }

}

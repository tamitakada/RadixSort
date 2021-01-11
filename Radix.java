import java.util.*;


public class Radix {
  public static int nth(int n, int col) {
    String val = ("" + n).substring(col, col + 1);
    return Integer.valueOf(val);
  }

  public static int length(int n) {
    return String.valueOf(Math.abs(n)).length();
  }

  public static void merge(MyLinkedList original, MyLinkedList[] buckets) {
    for (int i = 0; i < buckets.length; i++) {
      original.extend(buckets[i]);
    }
  }

}

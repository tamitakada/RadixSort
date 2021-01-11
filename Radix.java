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

  public static void radixSortSimple(SortableLinkedList data) {
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    for (int i = 0; i < 10; i++) {
      buckets[i] = new SortableLinkedList();
    }

    int maxLen = 1;
    for (int i = data.size() - 1; i >= 0; i--) {
      if (length(data.get(i)) > maxLen) maxLen = length(data.get(i));
      buckets[nth(data.get(i), 0)].add(data.get(i));
      data.remove(i);
    }

    merge(data, buckets);

    for (int i = 1; i <= maxLen; i++) {
      for (int j = 0; j < data.size(); j++) {
        if (length(data.get(j)) <= i) buckets[0].add(data.get(j));
        else {
          buckets[nth(data.get(j), i)].add(data.get(j));
        }
        data.remove(j);
        j--;
      }

      merge(data, buckets);
    }
  }

}

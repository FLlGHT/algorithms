package design;

import java.util.TreeSet;

/**
 * @author FLIGHT
 */
public class RangeModule {

  private final TreeSet<Integer> set;

  public RangeModule() {
    set = new TreeSet<>();
  }

  public void addRange(int left, int right) {
    for (int i = left; i < right; ++i) {
      set.add(i);
    }
  }

  public boolean queryRange(int left, int right) {
    int subsetSize = set.subSet(left, right).size();
    int queryRange = right - left;
    return subsetSize == queryRange;
  }

  public void removeRange(int left, int right) {
    for (int i = left; i < right; ++i) {
      set.remove(i);
    }
  }

  public static void main(String[] args) {
    RangeModule rangeModule = new RangeModule();
    rangeModule.addRange(10, 20);
    rangeModule.removeRange(14, 16);
    rangeModule.queryRange(10, 100);
  }
}

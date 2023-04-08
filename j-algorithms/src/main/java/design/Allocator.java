package design;

/**
 * 2502. Design Memory Allocator
 * <p>
 * You are given an integer n representing the size of a 0-indexed memory array. All memory units are initially free.
 * <p>
 * You have a memory allocator with the following functionalities:
 * <p>
 * Allocate a block of size consecutive free memory units and assign it the id mID.
 * Free all memory units with the given id mID.
 * Note that:
 * <p>
 * Multiple blocks can be allocated to the same mID.
 * You should free all the memory units with mID, even if they were allocated in different blocks.
 * Implement the Allocator class:
 * <p>
 * Allocator(int n) Initializes an Allocator object with a memory array of size n.
 * int allocate(int size, int mID) Find the leftmost block of size consecutive free memory units and allocate it with the id mID. Return the block's first index. If such a block does not exist, return -1.
 * int free(int mID) Free all memory units with the id mID. Return the number of memory units you have freed.
 */
public class Allocator {

  private final int size;
  private final int[] memory;

  public Allocator(int n) {
    size = n;
    memory = new int[n];
  }

  public int allocate(int size, int mID) {
    int freeConsecutive = 0;
    for (int i = 0; i < memory.length; ++i) {
      if (memory[i] == 0)
        freeConsecutive++;
      else
        freeConsecutive = 0;

      if (freeConsecutive == size) {
        int leftmost = i - size + 1;
        fill(leftmost, i, mID);
        return leftmost;
      }
    }

    return -1;
  }

  private void fill(int from, int to, int mID) {
    for (int i = from; i <= to; ++i) {
      memory[i] = mID;
    }
  }

  public int free(int mID) {
    int count = 0;
    for (int i = 0; i < memory.length; ++i) {
      if (memory[i] == mID) {
        count++;
        memory[i] = 0;
      }
    }

    return count;
  }

}

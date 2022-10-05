package design;

import java.util.ArrayList;
import java.util.List;

/**
 * 1656. Design an Ordered Stream
 * <p>
 * There is a stream of n (idKey, value) pairs arriving in an arbitrary order,
 * where idKey is an integer between 1 and n and value is a string. No two pairs have the same id.
 * <p>
 * Design a stream that returns the values in increasing order of their IDs by returning a chunk (list) of values after each insertion.
 * The concatenation of all the chunks should result in a list of the sorted values.
 * <p>
 * Implement the OrderedStream class:
 * <p>
 * OrderedStream(int n) Constructs the stream to take n values.
 * String[] insert(int idKey, String value) Inserts the pair (idKey, value) into the stream,
 * then returns the largest possible chunk of currently inserted values that appear next in the order.
 * <p>
 * <p>
 * Example:
 * <p>
 * <p>
 * <p>
 * Input
 * ["OrderedStream", "insert", "insert", "insert", "insert", "insert"]
 * [[5], [3, "ccccc"], [1, "aaaaa"], [2, "bbbbb"], [5, "eeeee"], [4, "ddddd"]]
 * Output
 * [null, [], ["aaaaa"], ["bbbbb", "ccccc"], [], ["ddddd", "eeeee"]]
 * <p>
 * Explanation
 * // Note that the values ordered by ID is ["aaaaa", "bbbbb", "ccccc", "ddddd", "eeeee"].
 * OrderedStream os = new OrderedStream(5);
 * os.insert(3, "ccccc"); // Inserts (3, "ccccc"), returns [].
 * os.insert(1, "aaaaa"); // Inserts (1, "aaaaa"), returns ["aaaaa"].
 * os.insert(2, "bbbbb"); // Inserts (2, "bbbbb"), returns ["bbbbb", "ccccc"].
 * os.insert(5, "eeeee"); // Inserts (5, "eeeee"), returns [].
 * os.insert(4, "ddddd"); // Inserts (4, "ddddd"), returns ["ddddd", "eeeee"].
 * // Concatentating all the chunks returned:
 * // [] + ["aaaaa"] + ["bbbbb", "ccccc"] + [] + ["ddddd", "eeeee"] = ["aaaaa", "bbbbb", "ccccc", "ddddd", "eeeee"]
 * // The resulting order is the same as the order above.
 */
public class OrderedStream {

    private final String[] result;
    private int pointer = 0;

    public OrderedStream(int n) {
        result = new String[n];
    }

    public List<String> insert(int idKey, String value) {
        result[idKey - 1] = value;
        List<String> chunks = new ArrayList<>();

        while (pointer < result.length && result[pointer] != null) {
            chunks.add(result[pointer]);
            pointer++;
        }

        return chunks;
    }
}

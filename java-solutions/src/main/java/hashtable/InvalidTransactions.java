package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1169. Invalid Transactions
 * A transaction is possibly invalid if:
 * <p>
 * the amount exceeds $1000, or;
 * if it occurs within (and including) 60 minutes of another transaction with the same name in a different city.
 * You are given an array of strings transaction where transactions[i] consists of comma-separated values
 * representing the name, time (in minutes), amount, and city of the transaction.
 * <p>
 * Return a list of transactions that are possibly invalid. You may return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
 * Output: ["alice,20,800,mtv","alice,50,100,beijing"]
 * Explanation: The first transaction is invalid because the second transaction occurs within a difference of 60 minutes,
 * have the same name and is in a different city. Similarly, the second one is invalid too.
 * Example 2:
 * <p>
 * Input: transactions = ["alice,20,800,mtv","alice,50,1200,mtv"]
 * Output: ["alice,50,1200,mtv"]
 * Example 3:
 * <p>
 * Input: transactions = ["alice,20,800,mtv","bob,50,1200,mtv"]
 * Output: ["bob,50,1200,mtv"]
 */
public class InvalidTransactions {

  private static final int MAX_AMOUNT = 1000;
  private static final int MIN_IN_HOUR = 60;
  public List<String> invalidTransactions(String[] transactions) {
    Map<String, List<Transaction>> personTransactions = new HashMap<>();
    List<String> invalid = new ArrayList<>();

    for (String rawTransaction : transactions) {
      Transaction transaction = Transaction.createFromRaw(rawTransaction);
      personTransactions.computeIfAbsent(transaction.name(), p -> new ArrayList<>()).add(transaction);
    }

    for (String rawTransaction : transactions) {
      Transaction transaction = Transaction.createFromRaw(rawTransaction);
      if (isInvalid(transaction, personTransactions.get(transaction.name())))
        invalid.add(rawTransaction);
    }

    return invalid;
  }

  private boolean isInvalid(Transaction transaction, List<Transaction> transactions) {
    if (transaction.amount >= MAX_AMOUNT)
      return true;

    for (Transaction anotherTransaction : transactions) {
      if (differentCity(transaction, anotherTransaction) && inHour(transaction, anotherTransaction))
        return true;
    }

    return false;
  }

  private boolean differentCity(Transaction first, Transaction second) {
    return !first.city().equals(second.city());
  }

  private boolean inHour(Transaction first, Transaction second) {
    return Math.abs(first.time() - second.time()) <= MIN_IN_HOUR;
  }


  private record Transaction(String name, int time, int amount, String city) {

    private static Transaction createFromRaw(String rawTransaction) {
      String[] parts = rawTransaction.split(",");
      return new Transaction(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), parts[3]);
    }
  }
}

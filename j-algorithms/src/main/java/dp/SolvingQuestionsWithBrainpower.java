package dp;

/**
 * 2140. Solving Questions With Brainpower
 * You are given a 0-indexed 2D integer array questions where questions[i] = [pointsi, brainpoweri].
 * <p>
 * The array describes the questions of an exam, where you have to process the questions in order (i.e., starting from question 0) and make a decision whether to solve or skip each question. Solving question i will earn you pointsi points but you will be unable to solve each of the next brainpoweri questions. If you skip question i, you get to make the decision on the next question.
 * <p>
 * For example, given questions = [[3, 2], [4, 3], [4, 4], [2, 5]]:
 * If question 0 is solved, you will earn 3 points but you will be unable to solve questions 1 and 2.
 * If instead, question 0 is skipped and question 1 is solved, you will earn 4 points but you will be unable to solve questions 2 and 3.
 * Return the maximum points you can earn for the exam.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: questions = [[3,2],[4,3],[4,4],[2,5]]
 * Output: 5
 * Explanation: The maximum points can be earned by solving questions 0 and 3.
 * - Solve question 0: Earn 3 points, will be unable to solve the next 2 questions
 * - Unable to solve questions 1 and 2
 * - Solve question 3: Earn 2 points
 * Total points earned: 3 + 2 = 5. There is no other way to earn 5 or more points.
 * Example 2:
 * <p>
 * Input: questions = [[1,1],[2,2],[3,3],[4,4],[5,5]]
 * Output: 7
 * Explanation: The maximum points can be earned by solving questions 1 and 4.
 * - Skip question 0
 * - Solve question 1: Earn 2 points, will be unable to solve the next 2 questions
 * - Unable to solve questions 2 and 3
 * - Solve question 4: Earn 5 points
 * Total points earned: 2 + 5 = 7. There is no other way to earn 7 or more points.
 */
public class SolvingQuestionsWithBrainpower {

  public long mostPoints(int[][] questions) {
    long[] dp = new long[questions.length + 1];

    for (int i = questions.length - 1; i >= 0; --i) {
      int[] question = questions[i];
      int points = question[0], brainpower = question[1];

      long previous = i + brainpower + 1 < dp.length ? dp[i + brainpower + 1] : 0;
      dp[i] = Math.max(previous + points, dp[i + 1]);
    }

    return dp[0];
  }
}

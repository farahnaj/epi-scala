package com.epi.java.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Football {

  /**
   * possible points:
   * 2, 3, 7
   * @param score
   * @return
   */
  public static Map<Integer, Integer> cache = new HashMap<>();

  public static int getScoreCombinations(int score) {
//    return execute(0, 2, score) +
//      execute(0, 3, score) +
//      execute(0, 7, score);

    return  execute(0, 2, score);
  }

  public static int execute(int acc, int value, int score) {
    if(score <= 0) {
      return acc;
    } else {
      return execute(acc + 1, value,score - value);
    }
  }

  /**
   * solution
   */
  public static int numCombinationsForFinalScore(int finalScore, List<Integer> scores) {

    int[][] numCombForScore = new int[scores.size()][finalScore + 1];

    for(int i = 0; i < scores.size(); i++) {

      numCombForScore[i][0] = 1;

      for(int j = 1; j <= finalScore; j++) {
        int withoutThisPlay = i - 1 >= 0 ? numCombForScore[i - 1][j] : 0;
        int withThisPlay = j >= scores.get(i) ? numCombForScore[i][j - scores.get(i)] : 0;
        numCombForScore[i][j] = withoutThisPlay + withThisPlay;
      }
    }
    return numCombForScore[scores.size() - 1][finalScore];
  }


  public static void main(String[] args) {
    //System.out.println(getScoreCombinations(7));
    List<Integer> scores = new ArrayList<>();
    scores.add(2);
    scores.add(3);
    scores.add(7);
    System.out.println(numCombinationsForFinalScore(7, scores));
  }
}

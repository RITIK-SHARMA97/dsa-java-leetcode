/*
Problem: Baseball Game (LeetCode)
Concept: Stack

Approach:
- Use a stack to store scores
- "+" → sum of last two scores
- "D" → double last score
- "C" → remove last score
- Number → push into stack

Time Complexity: O(n)
Space Complexity: O(n)
*/

// File: stack/BaseballGame.java

import java.util.Stack;

public class BaseballGame {

    public int calPoints(String[] operations) {

        Stack<Integer> stack = new Stack<>();

        for (String ops : operations) {

            if (ops.equals("+")) {
                int top = stack.pop();
                int second = stack.peek();
                stack.push(top);
                stack.push(top + second);

            } else if (ops.equals("C")) {
                stack.pop();

            } else if (ops.equals("D")) {
                stack.push(2 * stack.peek());

            } else {
                stack.push(Integer.parseInt(ops));
            }
        }

        int sum = 0;

        for (int score : stack) {
            sum += score;
        }

        return sum;
    }
}

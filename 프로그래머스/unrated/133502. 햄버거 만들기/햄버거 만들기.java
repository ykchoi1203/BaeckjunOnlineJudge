import java.util.Stack;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        int i = 0;
        int[] burger = {1, 3, 2, 1};
        Stack<Integer> stack = new Stack<>();
        while (i < ingredient.length) {
            stack.push(ingredient[i]);
            i++;
            if (stack.size() > 3) {
                if (stack.peek() == 1) {
                    int[] isBurger = new int[4];
                    
                    for (int j = 0; j < isBurger.length; j++) {
                        isBurger[j] = stack.pop();
                    }
                    if (isEquals(burger, isBurger)) {
                        answer++;
                    } else {
                        for (int j = isBurger.length - 1; j >= 0; j--) {
                            stack.push(isBurger[j]);
                        }
                    }
                }
            }

        }


        return answer;
    }

    private boolean isEquals(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }
        return true;
    }
}
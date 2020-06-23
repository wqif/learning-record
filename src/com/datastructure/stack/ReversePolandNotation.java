package com.datastructure.stack;

/**
 * @author Qifeng Wen
 * @date 2020-06-23 下午8:19
 */
public class ReversePolandNotation {
    public static int calculate(String[] ss) {
        SingleLikedListStack<Integer> stack = new SingleLikedListStack<>();
        for (String s : ss) {
            if (s.matches("\\d+")) {
                // 匹配多位数
                stack.push(Integer.parseInt(s));
            } else {
                // pop两个数 进行当前字符操作后入栈
                int num = stack.pop();
                switch (s) {
                    case "+":
                        stack.push(stack.pop() + num);
                        break;
                    case "-":
                        stack.push(stack.pop() - num);
                        break;
                    case "*":
                        stack.push(stack.pop() * num);
                        break;
                    case "/":
                        stack.push(stack.pop() / num);
                        break;
                    default:
                        throw new RuntimeException("表达式非法！");
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        // 逆波兰表达式
        // (1+2)*3-4 => 1 2 + 3 * 4 -
        String suffixExpression = "5 2 + 3 * 4 -";
        String[] arr = suffixExpression.split(" ");
        System.out.println(calculate(arr));
    }
}

package pers.wqf.datastructure.stack;

/**
 * @author Qifeng Wen
 * @date 2020-06-17 下午10:00
 */

/**
 * 用栈实现计算器
 */
public class Calculator {


    public static double calculate(SingleLikedListStack<Double> vals, SingleLikedListStack<Character> ops) {
        char op = ops.pop();
        double val = vals.pop();

        switch (op) {
            case '+':
                return vals.pop() + val;
            case '-':
                return vals.pop() - val;
            case '*':
                return vals.pop() * val;
            case '/':
                return vals.pop() / val;
            default:
                throw new RuntimeException("表达式非法！");
        }
    }

    public static void main(String[] args) {
        SingleLikedListStack<Double> vals = new SingleLikedListStack<>();
        SingleLikedListStack<Character> ops = new SingleLikedListStack<>();
        String expression = "(1+(((2+3)*(4+5))/3))";
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            switch (c) {
                case '(':
                    break;
                case ')':
                    vals.push(calculate(vals, ops));
                    break;
                case '+':
                    ops.push(c);
                    break;
                case '-':
                    ops.push(c);
                    break;
                case '*':
                    ops.push(c);
                    break;

                case '/':
                    ops.push(c);
                    break;
                default:
                    int num = c - '0';
                    if (num<0 || num>9) throw new RuntimeException("表达式非法！");
                    vals.push((double) (num));
            }
        }
        System.out.println(vals.pop());
    }
}

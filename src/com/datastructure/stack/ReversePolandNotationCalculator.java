package com.datastructure.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author Qifeng Wen
 * @date 2020-06-23 下午8:19
 */
public class ReversePolandNotationCalculator {


    private static int getValue(String s) {
        if (s.equals("+") || s.equals("-")) return 0;
        if (s.equals("*") || s.equals("/")) return 1;
        if (s.equals("(")) return 2;
        throw new RuntimeException("非法符号！");
    }

    /**
     * 比较优先级
     *
     * @param s1
     * @param s2
     * @return
     */
    private static boolean comparePriority(String s1, String s2) {
        return getValue(s1) - getValue(s2) > 0;
    }

    /**
     * 将中缀表达式转为list
     *
     * @param s
     * @return
     */
    private static List<String> ToInfixExpressionList(String s) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') { // 不是数字
                list.add(c + "");
            } else { //如果是数字（考虑多位数情况）
                int len = 1;
                for (int j = i + 1; j < s.length(); j++) {
                    c = s.charAt(j);
                    if (c >= '0' && c <= '9') len++;
                    else break;
                }
                list.add(s.substring(i, i + len));
                i += len - 1;
            }
        }
        return list;
    }

    /**
     * 中缀表达式转逆波兰表达式(后缀表达式)
     * 1.初始化一个栈（用于存储符号）和一个可变长度数组（存储结果）
     * 2.从左至右扫描中缀表达式
     * 3.遇到操作数直接追加到可变长度数组
     * 4.遇到符号时：
     * 1) 如果栈空或者栈顶符号为"("则直接将此符号入栈
     * 2) 否则判断若该符号比栈顶符号的优先级高则将此符号入栈
     * 3) 否则将栈顶符号弹出并追加到可变长度数组，跳到1)
     * 5.遇到括号
     * 1) 如果是"("，则直接入栈
     * 2) 如果是")"，则依次弹出栈顶元素追加到可变长度数组，知道栈顶为"(",此时一对括号丢弃
     * 6.重复步骤2-5，直达表达式最后
     * 7.将栈中元素一一弹出并追加到可变长度数组
     * 8.将可变长度数组拼接，得到的就是逆波兰表达式
     *
     * @param s 中缀表达式
     * @return
     */
    public static List<String> InfixExpression2RPN(String s) {
        List<String> list = ToInfixExpressionList(s);
        List<String> ret = new ArrayList<>();
        SingleLikedListStack<String> stack = new SingleLikedListStack<>();

        for (String item : list) {
            if (item.matches("\\d+")) { // 如果是操作数直接追加到stringBuilder
                ret.add(item);
            } else if (item.equals("(")) {
                stack.push(item);
            } else if (item.equals(")")) {
                // 依次弹出追加到可变长度数组直到栈顶元素是"("为止
                while (!stack.top().equals("(")) {
                    ret.add(stack.pop());
                }
                stack.pop(); // 将"("弹出，消除小括号
            } else {
                while (!stack.empty() && !stack.top().equals("(") && !comparePriority(item, stack.top())) {
                    ret.add(stack.pop());
                }
                stack.push(item);
            }
        }
        while (!stack.empty()) ret.add(stack.pop());
        return ret;
    }

    public static int calculate(List<String> ss) {
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
        System.out.println(calculate(Arrays.asList(arr)));
        System.out.println(InfixExpression2RPN("1+2*(23+4)-5"));
        System.out.println(calculate(InfixExpression2RPN("1+2*(23+4)-5")));
    }
}

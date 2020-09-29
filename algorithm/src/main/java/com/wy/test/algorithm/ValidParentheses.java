package com.wy.test.algorithm;

import java.util.HashMap;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
            
            有效字符串需满足：
       1.左括号必须用相同类型的右括号闭合。
       2.左括号必须以正确的顺序闭合。
            注意空字符串可被认为是有效字符串。
            
            示例 1:
            
            输入: "()"
            输出: true
            示例 2:
            
            输入: "()[]{}"
            输出: true
            示例 3:
            
            输入: "(]"
            输出: false
            示例 4:
            
            输入: "([)]"
            输出: false
            示例 5:
            
            输入: "{[]}"
            输出: true
            
 *
 */
public class ValidParentheses {
    
    // 解题思路: 使用栈(先进后出)
    // 左括号: 存储对应的右括号
    // 右括号: 判断栈为空或者栈顶数据是否一致, 
    
    public static void main(String[] args) {
        boolean valid = isValid("()[]{}");
        System.out.println(valid);
    }
    
    
    private static boolean isValid(String s) {
        int length = s.length();
        if (length % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if ('(' == c) {
                stack.push(')');
            } else if ('[' == c) {
                stack.push(']');
            } else if ('{' == c) {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
    
    
    // 效率不高,思路简单
    public static boolean isValid2(String s) {
        String ss  = s.trim();
        // 从中间开始取值判断
        int zjs = ss.length() / 2; 
        for (int i = zjs; i > 0; i--) {
            ss = ss.replace("()", "").replace("{}", "").replace("[]", "");
        }
        return ss.length() == 0;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    

}


/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package string.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class App {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("num : ");
    String input = scanner.next();

    List<Character> chars = input.chars()
        .mapToObj(c -> (char) c)
        .toList();

    run(chars);
  }

  public static double run(List<Character> chars) {
    StringBuilder sb = new StringBuilder();

    Stack<Character> operatorStack = new Stack<>();
    Stack<Double> numberStack = new Stack<>();
    char sign;
    int index = 0;
    for (Character c : chars) {
      if (c == ' ') {
        index++;
        continue;
      }

      if (index == chars.size() - 1) {
        sb.append(c);
        numberStack.add(Double.parseDouble(sb.toString()));
        checkLastStack(operatorStack, numberStack);
      }

      if (c.equals('*')) {
        sign = '*';
        stackAdd(sb, operatorStack, numberStack, sign);
        sb.setLength(0);
      }

      if (c.equals('+')) {
        sign = '+';
        stackAdd(sb, operatorStack, numberStack, sign);
        sb.setLength(0);
      }

      if (c.equals('-')) {
        sign = '-';
        stackAdd(sb, operatorStack, numberStack, sign);
        sb.setLength(0);
      }

      if (c.equals('/')) {
        sign = '/';
        stackAdd(sb, operatorStack, numberStack, sign);
        sb.setLength(0);
      }

      if (c >= '0' && c <= '9') {
        sb.append(c);
      }

      index++;
    }

    return calculate(operatorStack, numberStack);
  }

  public static void checkLastStack(Stack<Character> operatorStack, Stack<Double> numberStack) {

    if (!operatorStack.isEmpty()) {
      Character peek = operatorStack.peek();
      if (peek.equals('*') || peek.equals('/')) {
        calculateOne(operatorStack, numberStack);
      }
    }

  }

  public static void calculateOne(Stack<Character> operatorStack, Stack<Double> numberStack) {

    Double rightValue = numberStack.pop();
    Double leftValue = numberStack.pop();

    Character operator = operatorStack.pop();
    operatorSelect(numberStack, leftValue, rightValue, operator);

  }

  public static double calculate(Stack<Character> operatorStack, Stack<Double> numberStack) {

    reverseStack(operatorStack);
    reverseStack(numberStack);

    while (!numberStack.isEmpty()) {
      if (numberStack.size() == 1) {
        break;
      }
      Double leftValue = numberStack.pop();
      Double rightValue = numberStack.pop();

      Character operator = operatorStack.pop();
      operatorSelect(numberStack, leftValue, rightValue, operator);

    }
    return numberStack.pop();
  }

  public static <T> void reverseStack(Stack<T> stack) {

    List<T> tempList = new ArrayList<>(stack);
    stack.clear();

    for (int i = tempList.size() - 1; i >= 0; i--) {
      stack.push(tempList.get(i));
    }

  }

  public static void operatorSelect(Stack<Double> numberStack, Double leftValue,
      Double rightValue,
      Character operator) {

    double result;
    if (operator.equals('+')) {
      result = add(leftValue, rightValue);
      numberStack.push(result);
    }
    if (operator.equals('-')) {
      result = subtract(leftValue, rightValue);
      numberStack.push(result);
    }
    if (operator.equals('*')) {
      result = multiply(leftValue, rightValue);
      numberStack.push(result);
    }
    if (operator.equals('/')) {
      result = divide(leftValue, rightValue);
      numberStack.push(result);
    }
  }

  public static void stackAdd(StringBuilder sb, Stack<Character> operatorStack,
      Stack<Double> numberStack, Character sign) {

    numberStack.add(Double.parseDouble(sb.toString()));
    if (sign.equals('+')) {
      if (!operatorStack.isEmpty()) {
        Character peek = operatorStack.peek();
        if (peek.equals('*') || peek.equals('/')) {
          calculateOne(operatorStack, numberStack);
        }
      }
    }
    if (sign.equals('-')) {
      if (!operatorStack.isEmpty()) {
        Character peek = operatorStack.peek();
        if (peek.equals('*') || peek.equals('/')) {
          calculateOne(operatorStack, numberStack);
        }
      }
    }

    if (sign.equals('*')) {
      if (!operatorStack.isEmpty()) {
        Character peek = operatorStack.peek();
        if (peek.equals('/')) {
          calculateOne(operatorStack, numberStack);
        }
      }
    }

    if (sign.equals('/')) {
      if (!operatorStack.isEmpty()) {
        Character peek = operatorStack.peek();
        if (peek.equals('*')) {
          calculateOne(operatorStack, numberStack);
        }
      }
    }

    operatorStack.add(sign);
  }

  public static double add(double leftValue, double rightValue) {
    return leftValue + rightValue;
  }

  public static double subtract(double leftValue, double rightValue) {
    return leftValue - rightValue;
  }

  public static double multiply(double leftValue, double rightValue) {
    return leftValue * rightValue;
  }

  public static double divide(double leftValue, double rightValue) {
    if (rightValue == 0) {
      throw new IllegalStateException("0으로 나눌 수 없습니다");
    }
    return leftValue / rightValue;
  }

}

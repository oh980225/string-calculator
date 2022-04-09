package com.string.calculator.collection;

import com.string.calculator.OperatorSign;

import java.util.Stack;

public class OperatorStack {

  private Stack<OperatorSign> stack = new Stack<>();

  OperatorSign getOne() {
    return stack.pop();
  }

  int size() {
    return stack.size();
  }

  void add(OperatorSign operatorSign) {
    stack.add(operatorSign);
  }

  void reverse() {
    Stack<OperatorSign> temp = new Stack<>();

    while (!stack.isEmpty()) {
      OperatorSign pop = stack.pop();
      temp.add(pop);
    }
    stack = temp;
  }

  boolean existHighOperatorSignAtTheTop() {
    if (stack.isEmpty()) {
      return false;
    }

    OperatorSign lastOperator = stack.peek();

    return lastOperator == OperatorSign.divide || lastOperator == OperatorSign.multiply;
  }
}

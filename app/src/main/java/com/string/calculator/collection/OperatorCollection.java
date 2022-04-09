package com.string.calculator.collection;

import com.string.calculator.OperatorSign;

import java.util.Stack;

public class OperatorCollection {

  private Stack<OperatorSign> operatorSignStack = new Stack<>();

  OperatorSign getOne() {
    return operatorSignStack.pop();
  }

  int size() {
    return operatorSignStack.size();
  }

  void add(OperatorSign operatorSign) {
    operatorSignStack.add(operatorSign);
  }

  void reverse() {
    Stack<OperatorSign> temp = new Stack<>();

    while (!operatorSignStack.isEmpty()) {
      OperatorSign pop = operatorSignStack.pop();
      temp.add(pop);
    }
    operatorSignStack = temp;
  }

  boolean existHighOperatorSignAtTheTop() {
    if (operatorSignStack.isEmpty()) {
      return false;
    }

    OperatorSign lastOperator = operatorSignStack.peek();

    return lastOperator == OperatorSign.divide || lastOperator == OperatorSign.multiply;
  }
}

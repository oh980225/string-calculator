package com.string.calculator.collection;

import com.string.calculator.OperatorSign;

import java.util.Stack;

public class OperatorCollection {

  private Stack<OperatorSign> operatorSignStack = new Stack<>();

  public OperatorSign getOne() {
    return operatorSignStack.pop();
  }

  public int size() {
    return operatorSignStack.size();
  }

  public void add(OperatorSign operatorSign) {
    operatorSignStack.add(operatorSign);
  }

  public void reverse() {
    Stack<OperatorSign> temp = new Stack<>();

    while (!operatorSignStack.isEmpty()) {
      OperatorSign pop = operatorSignStack.pop();
      temp.add(pop);
    }
    operatorSignStack = temp;
  }

  public boolean existHighOperatorSign(NumberCollection numberCollection) {
    if (operatorSignStack.isEmpty()) {
      return false;
    }

    // 스택에 연산자보다 숫자가 더 많아야함
    if (operatorSignStack.size() >= numberCollection.size()) {
      return false;
    }

    OperatorSign lastOperator = operatorSignStack.peek();

    return lastOperator == OperatorSign.divide || lastOperator == OperatorSign.multiply;
  }
}

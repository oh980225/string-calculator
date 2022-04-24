package com.string.calculator;

import java.util.Stack;

class HighOperatorCondition implements PreCalculateCondition {
  private final Stack<OperatorSign> operatorSignStack;

  public HighOperatorCondition(Stack<OperatorSign> operatorSignStack) {
    this.operatorSignStack = operatorSignStack;
  }

  @Override
  public boolean check() {
    if (operatorSignStack.isEmpty()) {
      return false;
    }

    OperatorSign lastOperator = operatorSignStack.peek();

    return lastOperator == OperatorSign.divide || lastOperator == OperatorSign.multiply;
  }
}

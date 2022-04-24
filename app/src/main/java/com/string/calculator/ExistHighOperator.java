package com.string.calculator;

import java.util.Stack;

class ExistHighOperator {
  boolean check(Stack<OperatorSign> operatorSignStack) {
    if (operatorSignStack.isEmpty()) {
      return false;
    }

    OperatorSign lastOperator = operatorSignStack.peek();

    return lastOperator == OperatorSign.divide || lastOperator == OperatorSign.multiply;
  }
}

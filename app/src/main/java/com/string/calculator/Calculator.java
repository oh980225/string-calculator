package com.string.calculator;

import com.string.calculator.calculate.ArithmeticOperation;
import com.string.calculator.calculate.OperationFactory;
import com.string.calculator.collection.FormulaStack;


public class Calculator {
  private final OperationFactory operationFactory = new OperationFactory();

  public String executeForBinary(String leftValue, String rightValue, OperatorSign operatorSign) {
    ArithmeticOperation operation = operationFactory.create(leftValue, rightValue);

    return operation.calculateOne(operatorSign);
  }

  public String executeForTheRestInStack(FormulaStack stack) {
    stack.reverse();

    while (stack.needToCalculate()) {
      stack.put(executeForBinary(stack.popNumber(), stack.popNumber(), stack.popOperator()));
    }

    return stack.popNumber();
  }
}

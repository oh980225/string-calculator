package com.string.calculator;

import com.string.calculator.operation.ArithmeticOperation;
import com.string.calculator.operation.OperationFactory;

public class Calculator {

  private final OperationFactory operationFactory;

  public Calculator(OperationFactory calculateFactory) {
    this.operationFactory = calculateFactory;
  }

  public StringNumber execute(Binomial binomial) {
    // 객체 생성을 동적으로 해야하는 경우
    String leftValue = binomial.left().value();
    String rightValue = binomial.right().value();
    ArithmeticOperation operation = operationFactory.create(leftValue, rightValue);
    return new StringNumber(operation.calculateOne(binomial.operator()));
  }
}

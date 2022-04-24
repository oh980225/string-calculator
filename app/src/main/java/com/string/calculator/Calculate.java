package com.string.calculator;

import com.string.calculator.calculate.ArithmeticOperation;
import com.string.calculator.calculate.OperationFactory;


public class Calculate {

  private final OperationFactory operationFactory;

  public Calculate(OperationFactory calculateFactory) {
    this.operationFactory = calculateFactory;
  }

  public StringNumber one(Binomial binomial) {
    // 객체 생성을 동적으로 해야하는 경우
    ArithmeticOperation operation = operationFactory.create(binomial.left().value(), binomial.right().value());
    return new StringNumber(operation.calculateOne(binomial.operator()));
  }
}

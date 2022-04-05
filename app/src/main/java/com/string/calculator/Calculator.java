package com.string.calculator;

import com.string.calculator.calculate.ArithmeticOperation;
import com.string.calculator.calculate.OperationFactory;
import com.string.calculator.collection.NumberCollection;
import com.string.calculator.collection.OperatorCollection;


public class Calculator {
  private final OperationFactory operationFactory;

  public Calculator(OperationFactory calculateFactory) {
    this.operationFactory = calculateFactory;
  }

  public void executeForBinary(NumberCollection numberCollection, OperatorCollection operatorCollection) {
    String leftValue = numberCollection.getOne();
    String rightValue = numberCollection.getOne();
    OperatorSign operatorSign = operatorCollection.getOne();
    ArithmeticOperation operation = operationFactory.create(leftValue, rightValue);
    numberCollection.add(operation.calculateOne(operatorSign));
  }

  String execute(Formula formula) {
    return null;
  }
}

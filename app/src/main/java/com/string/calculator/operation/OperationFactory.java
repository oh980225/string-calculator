package com.string.calculator.operation;

import static java.lang.Math.multiplyExact;

public class OperationFactory {

  public ArithmeticOperation create(String leftValue, String rightValue) {
    if (isPrimitive(leftValue, rightValue)) {
      return new PrimitiveOperation(leftValue, rightValue);
    }
    return new BigIntegerOperation(leftValue, rightValue);
  }

  private boolean isPrimitive(String leftValue, String rightValue) {
    try {
      multiplyExact(Long.parseLong(leftValue), Long.parseLong(rightValue));
      return true;
    } catch (ArithmeticException | NumberFormatException e) {
      return false;
    }
  }
}

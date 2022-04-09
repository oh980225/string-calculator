package com.string.calculator.collection;

import com.string.calculator.OperatorSign;

import static com.string.calculator.OperatorSign.isSupportedOperator;

public class FormulaStack {
  private final NumberStack numberStack = new NumberStack();
  private final OperatorStack operatorStack = new OperatorStack();

  public void put(String element) {
    if (isSupportedOperator(element.charAt(0))) {
      operatorStack.add(OperatorSign.valueOf(element.charAt(0)));
      return;
    }

    numberStack.add(element);
  }

  public boolean needToCalculateInAdvance() {
    return operatorStack.existHighOperatorSignAtTheTop() &&
      (operatorStack.size() < numberStack.size());
  }

  public void reverse() {
    numberStack.reverse();
    operatorStack.reverse();
  }

  public boolean needToCalculate() {
    return numberStack.size() > 1 && operatorStack.size() != 0;
  }

  public String popNumber() {
    return numberStack.getOne();
  }

  public OperatorSign popOperator() {
    return operatorStack.getOne();
  }
}

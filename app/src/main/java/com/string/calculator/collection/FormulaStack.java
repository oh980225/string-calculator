package com.string.calculator.collection;

import com.string.calculator.OperatorSign;

import static com.string.calculator.OperatorSign.isSupportedOperator;

public class FormulaStack {
  private final NumberCollection numberCollection = new NumberCollection();
  private final OperatorCollection operatorCollection = new OperatorCollection();

  public void put(String element) {
    if (isSupportedOperator(element.charAt(0))) {
      operatorCollection.add(OperatorSign.valueOf(element.charAt(0)));
      return;
    }

    numberCollection.add(element);
  }

  public boolean needToCalculateInAdvance() {
    return operatorCollection.existHighOperatorSignAtTheTop() &&
      (operatorCollection.size() < numberCollection.size());
  }

  public void reverse() {
    numberCollection.reverse();
    operatorCollection.reverse();
  }

  public boolean needToCalculate() {
    return numberCollection.size() > 1 && operatorCollection.size() != 0;
  }

  public String popNumber() {
    return numberCollection.getOne();
  }

  public OperatorSign popOperator() {
    return operatorCollection.getOne();
  }
}

package com.string.calculator;

import com.string.calculator.collection.NumberCollection;
import com.string.calculator.collection.OperatorCollection;

import java.util.Arrays;

import static com.string.calculator.CalculatePolicy.needToCalculateInAdvance;
import static com.string.calculator.OperatorSign.isSupportedOperator;

class Formula {
  private final NumberCollection numberCollection = new NumberCollection();
  private final OperatorCollection operatorCollection = new OperatorCollection();
  private final Calculator calculator = new Calculator();

  Formula(String stringFormula) {
    var list = Arrays.stream(stringFormula.split(" ")).toList();
    list.forEach(element -> {
      putAppropriateCollection(element);

      if (needToCalculateInAdvance(numberCollection, operatorCollection)) {
        calculator.executeForBinary(numberCollection, operatorCollection);
      }
    });
  }

  private void putAppropriateCollection(String element) {
    if (isSupportedOperator(element.charAt(0))) {
      operatorCollection.add(OperatorSign.valueOf(element.charAt(0)));
      return;
    }

    numberCollection.add(element);
  }

  String result() {
    numberCollection.reverse();
    operatorCollection.reverse();

    while (numberCollection.size() > 1) {
      calculator.executeForBinary(numberCollection, operatorCollection);
    }

    return numberCollection.getOne();
  }
}

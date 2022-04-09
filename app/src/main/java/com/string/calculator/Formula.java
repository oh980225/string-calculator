package com.string.calculator;

import com.string.calculator.collection.FormulaStack;

import java.util.Arrays;

class Formula {
  private final FormulaStack stack = new FormulaStack();
  private final Calculator calculator = new Calculator();

  Formula(String stringFormula) {
    var list = Arrays.stream(stringFormula.split(" ")).toList();
    list.forEach(element -> {
      stack.put(element);

      if (stack.needToCalculateInAdvance()) {
        stack.put(calculator.executeForBinary(stack.popNumber(), stack.popNumber(), stack.popOperator()));
      }
    });
  }

  String result() {
    return calculator.executeForTheRestInStack(stack);
  }
}

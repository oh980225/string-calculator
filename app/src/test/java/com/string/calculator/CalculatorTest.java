package com.string.calculator;

import com.string.calculator.collection.FormulaStack;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class CalculatorTest {
  @Test
  void executeForBinary() {
    var calculator = new Calculator();

    var actual = calculator.executeForBinary("12", "5", OperatorSign.plus);

    assertThat(actual, is("17"));
  }

  @Test
  void executeForTheRestInStack() {
    var calculator = new Calculator();
    var formulaStack = new FormulaStack();
    formulaStack.put("1");
    formulaStack.put("+");
    formulaStack.put("5");
    formulaStack.put("-");
    formulaStack.put("1");

    var actual = calculator.executeForTheRestInStack(formulaStack);

    assertThat(actual, is("5"));
  }
}
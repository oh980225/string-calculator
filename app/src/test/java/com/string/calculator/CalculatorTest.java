package com.string.calculator;

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
}
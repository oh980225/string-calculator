package com.string.calculator;

import com.string.calculator.calculate.OperationFactory;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class CalculatorTest {

  @Test
  void execute() {
    // input: 쪼갠 수식(Formular)을 넣으면
    // output: 그 계산 결과 (String)
    var calculator = new Calculator(new OperationFactory());

    var actual = calculator.execute(new Formula("123 + 23 * 15"));

    assertThat(actual, is("468"));
  }
}
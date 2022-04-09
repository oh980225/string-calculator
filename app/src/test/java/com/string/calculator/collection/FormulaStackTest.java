package com.string.calculator.collection;

import com.string.calculator.OperatorSign;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FormulaStackTest {

  @Test
  void put_number() {
    var stack = new FormulaStack();
    stack.put("15");

    var actual = stack.popNumber();

    assertThat(actual, is("15"));
  }

  @Test
  void put_operator() {
    var stack = new FormulaStack();
    stack.put("+");

    var actual = stack.popOperator();

    assertThat(actual, is(OperatorSign.plus));
  }

  @Test
  void needToCalculateInAdvance() {
    var stack = new FormulaStack();
    stack.put("25");
    stack.put("*");
    stack.put("4");

    var actual = stack.needToCalculateInAdvance();

    assertThat(actual, is(true));
  }

  @Test
  void needToCalculate() {
    var stack = new FormulaStack();
    stack.put("25");
    stack.put("+");
    stack.put("4");

    var actual = stack.needToCalculate();

    assertThat(actual, is(true));
  }
}
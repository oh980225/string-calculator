package com.string.calculator;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class FormulaTest {
  @Test
  void result() {
    var formula = new Formula("123 + 23 * 12 - 10 + 1 * 1");

    var actual = formula.result();

    assertThat(actual, is("390"));
  }
}
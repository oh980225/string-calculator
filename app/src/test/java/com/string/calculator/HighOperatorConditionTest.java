package com.string.calculator;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class HighOperatorConditionTest {
  @Test
  void check() {
    Stack<OperatorSign> stack = new Stack<>();
    stack.push(OperatorSign.plus);
    stack.push(OperatorSign.subtract);
    stack.push(OperatorSign.multiply);
    var existHighOperator = new HighOperatorCondition(stack);

    var actual = existHighOperator.check();

    assertThat(actual, is(true));
  }
}
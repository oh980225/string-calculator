package com.string.calculator;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static com.string.calculator.OperatorSign.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class HighOperatorConditionTest {
  @Test
  void check() {
    Stack<OperatorSign> stack = new Stack<>();
    stack.push(plus);
    stack.push(subtract);
    stack.push(multiply);
    var existHighOperator = new HighOperatorCondition(stack);

    var actual = existHighOperator.check();

    assertThat(actual, is(true));
  }
}
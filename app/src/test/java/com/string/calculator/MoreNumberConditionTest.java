package com.string.calculator;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static com.string.calculator.OperatorSign.plus;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class MoreNumberConditionTest {
  @Test
  void check() {
    var condition = new MoreNumberCondition();
    Stack<String> numberStack = new Stack<>();
    Stack<OperatorSign> operatorSignStack = new Stack<>();
    numberStack.push("123");
    operatorSignStack.push(plus);
    numberStack.push("345");

    var actual = condition.check(numberStack, operatorSignStack);

    assertThat(actual, is(true));
  }
}
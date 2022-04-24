package com.string.calculator;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static com.string.calculator.OperatorSign.plus;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class MoreNumberConditionTest {
  @Test
  void check() {
    Stack<String> numberStack = new Stack<>();
    Stack<OperatorSign> operatorSignStack = new Stack<>();
    numberStack.push("123");
    operatorSignStack.push(plus);
    numberStack.push("345");
    var condition = new MoreNumberCondition(numberStack, operatorSignStack);

    var actual = condition.check();

    assertThat(actual, is(true));
  }
}
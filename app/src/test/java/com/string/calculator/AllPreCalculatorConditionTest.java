package com.string.calculator;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static com.string.calculator.OperatorSign.multiply;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class AllPreCalculatorConditionTest {
  @Test
  void check_exist_high_operator_and_more_number() {
    Stack<StringNumber> numberStack = new Stack<>();
    Stack<OperatorSign> operatorSignStack = new Stack<>();
    numberStack.push(new StringNumber("123"));
    operatorSignStack.push(multiply);
    numberStack.push(new StringNumber("456"));
    var condition = new AllPreCalculateCondition(numberStack, operatorSignStack);

    var actual = condition.check();

    assertThat(actual, is(true));
  }
}
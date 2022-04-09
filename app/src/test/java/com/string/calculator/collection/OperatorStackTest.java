package com.string.calculator.collection;

import com.string.calculator.OperatorSign;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class OperatorStackTest {
  @Test
  void existHighOperatorSignAtTheTop() {
    var operatorCollection = new OperatorStack();

    operatorCollection.add(OperatorSign.multiply);

    assertThat(operatorCollection.existHighOperatorSignAtTheTop(), is(true));

  }
}
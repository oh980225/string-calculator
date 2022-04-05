package com.string.calculator.collection;

import com.string.calculator.OperatorSign;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class OperatorCollectionTest {
  @Test
  void existHighOperatorSignAtTheTop() {
    var operatorCollection = new OperatorCollection();

    operatorCollection.add(OperatorSign.multiply);

    assertThat(operatorCollection.existHighOperatorSignAtTheTop(), is(true));

  }
}
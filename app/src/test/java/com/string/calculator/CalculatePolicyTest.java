package com.string.calculator;

import com.string.calculator.collection.NumberCollection;
import com.string.calculator.collection.OperatorCollection;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class CalculatePolicyTest {
  @Test
  void moreNumbersThanOperator() {
    var operatorCollection = new OperatorCollection();
    var numberCollection = new NumberCollection();
    numberCollection.add("12");
    operatorCollection.add(OperatorSign.multiply);
    numberCollection.add("23");

    assertThat(CalculatePolicy.needToCalculateInAdvance(numberCollection, operatorCollection), is(true));
  }
}
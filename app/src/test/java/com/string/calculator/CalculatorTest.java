package com.string.calculator;

import com.string.calculator.collection.NumberCollection;
import com.string.calculator.collection.OperatorCollection;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class CalculatorTest {
  @Test
  void executeForBinary() {
    var calculator = new Calculator();
    var numberCollection = new NumberCollection();
    var operatorCollection = new OperatorCollection();
    numberCollection.add("12");
    operatorCollection.add(OperatorSign.plus);
    numberCollection.add("5");

    calculator.executeForBinary(numberCollection, operatorCollection);

    assertThat(numberCollection.getOne(), is("17"));
  }
}
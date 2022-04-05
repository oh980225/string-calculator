package com.string.calculator;

import com.string.calculator.collection.NumberCollection;
import com.string.calculator.collection.OperatorCollection;

public class CalculatePolicy {
  static boolean needToCalculateInAdvance(NumberCollection numberCollection,
                                          OperatorCollection operatorCollection) {
    return operatorCollection.existHighOperatorSignAtTheTop() &&
      (operatorCollection.size() < numberCollection.size());
  }
}

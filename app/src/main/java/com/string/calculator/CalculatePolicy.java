package com.string.calculator;

import com.string.calculator.collection.NumberCollection;
import com.string.calculator.collection.OperatorCollection;

public class CalculatePolicy {
  static boolean moreNumbersThanOperator(OperatorCollection operatorCollection, NumberCollection numberCollection) {
    return operatorCollection.size() < numberCollection.size();
  }
}

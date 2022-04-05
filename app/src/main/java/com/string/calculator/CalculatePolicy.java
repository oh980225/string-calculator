package com.string.calculator;

import com.string.calculator.collection.NumberCollection;
import com.string.calculator.collection.OperatorCollection;

public class CalculatePolicy {
  static boolean moreNumbersThanOperator(NumberCollection numberCollection, OperatorCollection operatorCollection) {
    return operatorCollection.size() < numberCollection.size();
  }
}

package com.string.calculator;

import java.util.Stack;

public class MoreNumberCondition {
  boolean check(Stack<String> numberStack, Stack<OperatorSign> operatorSignStack) {
    return numberStack.size() > operatorSignStack.size();
  }
}

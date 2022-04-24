package com.string.calculator;

import java.util.Stack;

public class MoreNumberCondition implements PreCalculateCondition {
  private final Stack<StringNumber> numberStack;
  private final Stack<OperatorSign> operatorSignStack;

  public MoreNumberCondition(Stack<StringNumber> numberStack, Stack<OperatorSign> operatorSignStack) {
    this.numberStack = numberStack;
    this.operatorSignStack = operatorSignStack;
  }

  @Override
  public boolean check() {
    return numberStack.size() > operatorSignStack.size();
  }
}

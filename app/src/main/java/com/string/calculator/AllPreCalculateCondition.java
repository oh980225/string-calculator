package com.string.calculator;

import java.util.Stack;

public class AllPreCalculateCondition implements PreCalculateCondition {
  private final HighOperatorCondition highOperatorCondition;
  private final MoreNumberCondition moreNumberCondition;

  public AllPreCalculateCondition(Stack<StringNumber> numberStack, Stack<OperatorSign> operatorSignStack) {
    this.highOperatorCondition = new HighOperatorCondition(operatorSignStack);
    this.moreNumberCondition = new MoreNumberCondition(numberStack, operatorSignStack);
  }

  @Override
  public boolean check() {
    return highOperatorCondition.check() &&
      moreNumberCondition.check();
  }
}
